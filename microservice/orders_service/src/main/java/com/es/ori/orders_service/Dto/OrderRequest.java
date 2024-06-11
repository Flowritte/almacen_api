package com.es.ori.orders_service.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import  com.es.ori.orders_service.Entities.OrderItems;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest{ //crea la orden

    private List<OrderItemsRequest> OrderItems;
    //esta variable es la que declara la lista de objetos apedir en postman

}
