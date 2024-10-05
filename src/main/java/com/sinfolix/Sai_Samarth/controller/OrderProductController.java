package com.sinfolix.Sai_Samarth.controller;

import com.sinfolix.Sai_Samarth.DTO.ProductListByOrderDTO;
import com.sinfolix.Sai_Samarth.service.Impl.OrderProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-products")  // API Endpoint for Order Products
public class OrderProductController {
    @Autowired
    OrderProductServiceImpl orderProductServiceimpl;

    @GetMapping("/orderId/{order_id}")
    public ResponseEntity<ProductListByOrderDTO> getProductListByOrderID(@PathVariable long order_id) {
        ProductListByOrderDTO productListByOrderID = orderProductServiceimpl.getProductListByOrderId(order_id);
        return new ResponseEntity<>(productListByOrderID, HttpStatus.OK);
    }

    @GetMapping("/emailId/{email_id}")
    public ResponseEntity<List<ProductListByOrderDTO>> getProductListByEmailID(@PathVariable String email_id) {
        List<ProductListByOrderDTO> productListByEmailID = orderProductServiceimpl.getProductListByEmailId(email_id);
        return new ResponseEntity<>(productListByEmailID, HttpStatus.OK);
    }


}
