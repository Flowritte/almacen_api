package com.es.ori.orders_service.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private double price;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
}
