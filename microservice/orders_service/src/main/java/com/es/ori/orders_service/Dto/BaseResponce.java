package com.es.ori.orders_service.Dto;

public record BaseResponce(String[] errorMensaje) {
    //listado de errores
    public Boolean hasErrors(){
        return errorMensaje != null && errorMensaje.length > 0;
    }
}
