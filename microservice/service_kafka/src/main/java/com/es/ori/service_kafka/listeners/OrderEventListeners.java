package com.es.ori.service_kafka.listeners;

import com.es.ori.service_kafka.Events.OrderEvents;
import com.es.ori.service_kafka.Jutil.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventListeners {
    @KafkaListener(topics = "Order-topic")
    public void notification(String message){

        var orderevent = JsonUtil.fromJson(message, OrderEvents.class);
        //enviar email a cliente, sms,etc.
        //o notificar a otro servicio

        log.info("Order {} event received from order {} with {} items",orderevent.orderStatus(),
                orderevent.orderNumber(), orderevent.itemsCount());

    }
}
