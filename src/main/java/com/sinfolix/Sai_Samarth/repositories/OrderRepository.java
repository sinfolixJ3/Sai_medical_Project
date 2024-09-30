package com.sinfolix.Sai_Samarth.repositories;

import com.sinfolix.Sai_Samarth.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Integer> {
}
