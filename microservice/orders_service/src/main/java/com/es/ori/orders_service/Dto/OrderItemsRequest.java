package com.es.ori.orders_service.Dto;


import lombok.*;

@Data
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequest { //aqui es donde recibe los productos en lista


    private Long id;
    private String sku;
    private double price;
    private Long quantity;
}
