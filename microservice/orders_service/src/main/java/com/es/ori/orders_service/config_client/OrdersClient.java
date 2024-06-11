package com.es.ori.orders_service.config_client;


import com.es.ori.orders_service.Dto.BaseResponce;
import com.es.ori.orders_service.Dto.OrderItemsRequest;
import com.es.ori.orders_service.Dto.OrderRequest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Configuration
//@LoadBalanced
@FeignClient(name = "msvc-inventory", url = "http://msvc-inventory/api/v1/inventory/in-stock")
public interface OrdersClient {

    //endpoint para el servicio a llamar
    @GetMapping("/in-stock")
    BaseResponce FindCheckInventory(@RequestBody List<OrderItemsRequest> orderItemsRequest);

}
