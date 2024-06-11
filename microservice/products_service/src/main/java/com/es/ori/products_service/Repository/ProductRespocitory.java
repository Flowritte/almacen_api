package com.es.ori.products_service.Repository;

import com.es.ori.products_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespocitory extends JpaRepository<Product,Long> {

}
