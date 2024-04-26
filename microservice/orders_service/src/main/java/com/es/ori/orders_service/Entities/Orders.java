package com.es.ori.orders_service.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {

    @Id
    @Column(name = "id_orders")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrders;
    @Column(name = "order_number")
    private String orderNumber;

    @OneToMany(mappedBy = "orders",cascade =CascadeType.ALL )
    private List<OrderItems> orderItems;
}
