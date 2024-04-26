package com.es.ori.invetory_service.Service;

import com.es.ori.invetory_service.Dto.BaseResponce;
import com.es.ori.invetory_service.Dto.OrderItemsRequest;
import com.es.ori.invetory_service.Entity.Inventory;
import com.es.ori.invetory_service.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    public boolean isInStock(String sku) {
        var inventory = inventoryRepository.findBySku(sku);
        return inventory.filter(value -> value.getQuantity() >0).isPresent();
    }

    public BaseResponce areInStock(List<OrderItemsRequest> orderItems) {

        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemsRequest::getSku).toList();

        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderitem -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderitem.getSku())).findFirst();
            if (inventory.isEmpty()) {

                errorList.add("El producto con el SKU " + orderitem.getSku() + " no hay en existencias!");
            } else if (inventory.get().getQuantity() < orderitem.getQuantity()) {

                errorList.add("No hay suficientes piezas del producto con el SKU "+ orderitem.getSku() +
                        " no se puede hacer el pedido");
            }
        });
        return errorList.size() > 0 ? new BaseResponce(errorList.toArray(new String[0])) : new BaseResponce(null);
    }

}
