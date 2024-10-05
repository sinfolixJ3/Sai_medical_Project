package com.sinfolix.Sai_Samarth.service;

import com.sinfolix.Sai_Samarth.DTO.ProductListByOrderDTO;

import java.util.List;

public interface OrderProductService {
    ProductListByOrderDTO getProductListByOrderId(long orderId);

    List<ProductListByOrderDTO> getProductListByEmailId(String email_id);
}
