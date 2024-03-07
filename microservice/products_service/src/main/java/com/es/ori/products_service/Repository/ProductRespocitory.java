package com.es.ori.products_service.Repository;

import com.es.ori.products_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespocitory extends JpaRepository<Product,Long> {

}
