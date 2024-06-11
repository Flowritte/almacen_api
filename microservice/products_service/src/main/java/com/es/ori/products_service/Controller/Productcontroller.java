package com.es.ori.products_service.Controller;


import com.es.ori.products_service.Dto.ProductRequest;
import com.es.ori.products_service.Dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.es.ori.products_service.Service.PruductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Product")
public class Productcontroller {

   @Autowired
   private  PruductService pruductService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){

        this.pruductService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> GetAllProducts(){
        return this.pruductService.GetAllProducts();
    }

}
