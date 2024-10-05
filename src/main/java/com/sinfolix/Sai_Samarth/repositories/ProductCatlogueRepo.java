package com.sinfolix.Sai_Samarth.repositories;

import com.sinfolix.Sai_Samarth.entities.ProductCatlogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatlogueRepo extends JpaRepository<ProductCatlogue, Integer> {
    List<ProductCatlogue> findByEnabledTrue();
}
