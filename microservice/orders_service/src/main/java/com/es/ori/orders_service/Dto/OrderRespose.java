package com.es.ori.orders_service.Dto;

import com.es.ori.orders_service.Dto.HTTP.OrderItemsResponse;

import java.util.List;

public record OrderRespose(Long id, String orderNumber, List<OrderItemsResponse> OrderItems) {

}
