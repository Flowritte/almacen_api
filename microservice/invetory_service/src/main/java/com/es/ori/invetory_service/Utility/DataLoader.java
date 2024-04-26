package com.es.ori.invetory_service.Utility;


import com.es.ori.invetory_service.Entity.Inventory;
import com.es.ori.invetory_service.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Cargando datos...");
        if (inventoryRepository.findAll().size() == 0){

            inventoryRepository.saveAll(
                    List.of(
                            Inventory.builder().sku("0001").quantity(10L).build(),
                            Inventory.builder().sku("0002").quantity(20L).build(),
                            Inventory.builder().sku("0003").quantity(30L).build(),
                            Inventory.builder().sku("0004").quantity(0L).build()
                    )
            );
        }
        log.info("Datos cargados");
    }
}
