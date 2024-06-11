package com.es.ori.products_service.Service;

import com.es.ori.products_service.Dto.ProductRequest;
import com.es.ori.products_service.Dto.ProductResponse;
import com.es.ori.products_service.Entities.Product;
import com.es.ori.products_service.Repository.ProductRespocitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PruductService {

    @Autowired
    private final ProductRespocitory productRespocitory;
    public void createProduct(ProductRequest productRequest){
        //aqui llama a la clse que se creo para añadin un producto
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .descripcion(productRequest.getDescripcion())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                        .build();
        productRespocitory.save(product);
        log.info("Product added: {}",product);
    }

    public List<ProductResponse> GetAllProducts(){
        var products = productRespocitory.findAll();
        //retorna productos del repocitorio(todos)
        //para cinvertirlos y enlistarlos
        //.map convierte
        //stream divide cargas de la lista para ek trabajo en paralelo
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product){
        //metodo para transformar un objeto de tipo product del repocitorio
        //a uno de tipo productrespnse con atributos de product
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .descripcion(product.getDescripcion())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }


}
