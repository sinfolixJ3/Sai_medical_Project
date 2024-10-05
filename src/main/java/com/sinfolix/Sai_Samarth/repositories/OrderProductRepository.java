package com.sinfolix.Sai_Samarth.repositories;

import com.sinfolix.Sai_Samarth.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

    //    Find by order Id
    List<OrderProduct> findByOrderId(long orderId);
}
