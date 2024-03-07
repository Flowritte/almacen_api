package com.es.ori.products_service.Service;

import com.es.ori.products_service.Dto.ProductRequest;
import com.es.ori.products_service.Dto.ProductResponse;
import com.es.ori.products_service.Entities.Product;
import com.es.ori.products_service.Repository.ProductRespocitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PruductService {

    private final ProductRespocitory productRespocitory;
    public void createProduct(ProductRequest productRequest){
        var product = Product.builder()
                .id(productRequest.getId())
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
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .descripcion(product.getDescripcion())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }


}
