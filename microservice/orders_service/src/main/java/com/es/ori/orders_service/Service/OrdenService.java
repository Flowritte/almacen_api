package com.es.ori.orders_service.Service;


import com.es.ori.orders_service.Dto.BaseResponce;
import com.es.ori.orders_service.Dto.HTTP.OrderItemsResponse;
import com.es.ori.orders_service.Dto.OrderItemsRequest;
import com.es.ori.orders_service.Dto.OrderRequest;
import com.es.ori.orders_service.Dto.OrderRespose;
import com.es.ori.orders_service.Entities.Enums.OrderStatus;
import com.es.ori.orders_service.Entities.OrderItems;
import com.es.ori.orders_service.Entities.Orders;
import com.es.ori.orders_service.Events.OrderEvents;
import com.es.ori.orders_service.Jutil.JsonUtil;
import com.es.ori.orders_service.Repository.OderRepository;
import com.es.ori.orders_service.config_client.OrdersClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrdenService {

    @Autowired
    private OderRepository oderRepository;
    @Autowired
    private OrdersClient ordersClient;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void ordersClient(OrdersClient ordersClient) {
        //check inventory
        this.ordersClient = ordersClient;
    }


    public OrderRespose PlaceOrder(OrderRequest orderRequest) {
        //llama al repocitorio externo y compara si no crea una orden
        BaseResponce result = ordersClient.FindCheckInventory(orderRequest.getOrderItems());

        if (result != null && !result.hasErrors()) {
            Orders orders = new Orders();
            orders.setOrderNumber(UUID.randomUUID().toString());
            orders.setOrderItems(orderRequest.getOrderItems().stream()
                    .map(orderItemRequest -> mapOrderRequestToOrderItem(
                    orderItemRequest,orders)).toList());
            var saverorder = this.oderRepository.save(orders);
            //mensaje a al topico de ordenes
            this.kafkaTemplate.send("Order-topic", JsonUtil.toJson(
                    new OrderEvents(saverorder.getOrderNumber(),saverorder.getOrderItems()
                            .size(), OrderStatus.PLACED)
            ));

            return mapToOrderREsponse(orders);
        }else{
            throw new IllegalArgumentException("ALgunos productos no estan disponibles" +
                    "consulta en inventerio");
        }

    }
    public List<OrderRespose> getAllOrders(){
        List<Orders> orders = this.oderRepository.findAll();
        return orders.stream().map(this::mapToOrderREsponse).toList();
    }
    private OrderRespose mapToOrderREsponse(Orders order){
        return new OrderRespose(order.getIdOrders(),order.getOrderNumber(),order.getOrderItems()
                .stream().map(this::mapToOrderItemRequest).toList());
    }
    private OrderItemsResponse mapToOrderItemRequest(OrderItems orderItems){ //metodo que crea el orden de items
        return new OrderItemsResponse(orderItems.getId(),orderItems.getSku(),orderItems.getPrice(),
                orderItems.getQuantity());
    }

    private OrderItems mapOrderRequestToOrderItem(OrderItemsRequest orderItemRequest, Orders orders) {
        return OrderItems.builder()
                .id(orderItemRequest.getId())
                .sku(orderItemRequest.getSku())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .orders(orders)
                .build();
    }
}
