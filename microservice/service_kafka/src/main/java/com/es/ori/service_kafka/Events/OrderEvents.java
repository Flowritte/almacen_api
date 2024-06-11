package com.es.ori.service_kafka.Events;

import com.es.ori.service_kafka.Enums.OrderStatus;

public record OrderEvents(String orderNumber, int itemsCount, OrderStatus orderStatus) {//de aqui se envia al topco de ordenes

}
