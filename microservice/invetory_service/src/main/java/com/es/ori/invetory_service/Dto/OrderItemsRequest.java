package com.es.ori.orders_service.Dto;


import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequest {


    private Long id;
    private String SKU;
    private double price;
    private Long Quantity;
}
