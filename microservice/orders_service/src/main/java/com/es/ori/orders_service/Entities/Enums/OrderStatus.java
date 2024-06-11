package com.es.ori.orders_service.Entities.Enums;

public enum OrderStatus {//estados de la orden se comuniucara y enviara al topic
    //atravez del orderEvents
    PLACED,
    CANCELLED,
    SHIPPED,
    DELIVERED
}
