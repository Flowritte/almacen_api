package com.es.ori.products_service.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    //metodo para obtener datos del repocitorio
    //tiene las mismas propiedades que el entity
    //datos convertidos del repocitorio para utlizarlos

    private Long id;
    private String sku;
    private String name;
    private String descripcion;
    private Double price;
    private Boolean status;
}
