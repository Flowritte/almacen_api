package com.es.ori.orders_service.Events;

import com.es.ori.orders_service.Entities.Enums.OrderStatus;

public record OrderEvents(String orderNumber, int itemsCount, OrderStatus orderStatus) {//de aqui se envia al topco de ordenes

}
