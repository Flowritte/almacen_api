package com.es.ori.invetory_service.Controller;


import com.es.ori.invetory_service.Dto.BaseResponce;
import com.es.ori.invetory_service.Dto.OrderItemsRequest;
import com.es.ori.invetory_service.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku ){
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponce areInStock(@RequestBody List<OrderItemsRequest> orderItems){

        return  inventoryService.areInStock(orderItems);
    }
}
