package com.es.ori.invetory_service.Dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequest {


    private Long id;
    private String sku;
    private double price;
    private Long quantity;
}
