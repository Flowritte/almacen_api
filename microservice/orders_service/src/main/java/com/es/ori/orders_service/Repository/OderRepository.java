package com.es.ori.orders_service.Repository;

import com.es.ori.orders_service.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepository extends JpaRepository<Orders,Long> {



}
