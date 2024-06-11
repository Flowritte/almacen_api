package com.es.ori.products_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    //metodo para insertar datos al repocitorio
    //para poder crear el producto se necsita de esta clase
    //para poder llamarlo y poder trabjar con el el otroas instancias
    //donde se requiera
    //llamado "producto requerido"
    private String sku;
    private String name;
    private String descripcion;
    private Double price;
    private Boolean status;
}
