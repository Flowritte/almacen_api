package com.es.ori.orders_service.Controller;

import com.es.ori.orders_service.Dto.OrderRequest;
import com.es.ori.orders_service.Dto.OrderRespose;
import com.es.ori.orders_service.Service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String Placeorder(@RequestBody OrderRequest orderRequest){
        this.ordenService.PlaceOrder(orderRequest);
        return "Orden creada Correctamente";

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderRespose> getorders(){
        return this.ordenService.getAllOrders();
    }
}
