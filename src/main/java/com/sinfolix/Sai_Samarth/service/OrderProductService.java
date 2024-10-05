package com.sinfolix.Sai_Samarth.service;

import com.sinfolix.Sai_Samarth.DTO.ProductListByOrderDTO;

public interface OrderProductService {
    ProductListByOrderDTO getProductListByOrderId(long orderId);
}
