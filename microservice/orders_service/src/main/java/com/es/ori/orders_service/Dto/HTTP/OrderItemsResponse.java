package com.es.ori.orders_service.Dto.HTTP;

import lombok.Builder;
import lombok.NoArgsConstructor;

//en el record crea automatizadamente metodos getter,equals,hascode en los parentesis utiliza metodos inmiutables
//o finales
@Builder
public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {

}
