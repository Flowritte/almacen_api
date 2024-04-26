package com.es.ori.invetory_service.Dto;

public record BaseResponce(String[] errorMensaje) {
    public Boolean hasErrors(){
        return errorMensaje != null && errorMensaje.length > 0;
    }
}
