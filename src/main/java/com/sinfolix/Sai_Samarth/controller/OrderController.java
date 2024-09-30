package com.sinfolix.Sai_Samarth.controller;

import com.sinfolix.Sai_Samarth.DTO.OrderDTO;
import com.sinfolix.Sai_Samarth.DTO.OrderProductDTO;
import com.sinfolix.Sai_Samarth.DTO.OrderRequestDTO;
import com.sinfolix.Sai_Samarth.ENUM.StatusEnum;
import com.sinfolix.Sai_Samarth.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")  // API Endpoint for Orders
public class OrderController {
    @Autowired
    OrderServiceImpl orderServiceImpl;

    @PostMapping("/")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderDTO order = new OrderDTO();
        // map orderRequestDTO to Order
        order.setCustomerAddress(orderRequestDTO.getCustomerAddress());
        order.setCustomerEmail(orderRequestDTO.getCustomerEmail());
        order.setCustomerName(orderRequestDTO.getCustomerName());
        order.setOrderDate(LocalDate.now());
        order.setStatus(StatusEnum.ORDER_PLACED.getStatus());
        order.setModified_time(LocalDate.now());

        List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
        for (OrderProductDTO orderProductDTO : orderRequestDTO.getOrderProductDTOList()) {
            OrderProductDTO newOrderProductDTO = new OrderProductDTO();
            newOrderProductDTO.setProductCatlogue(orderProductDTO.getProductCatlogue());
            newOrderProductDTO.setQuantity(orderProductDTO.getQuantity());
            orderProductDTOList.add(newOrderProductDTO);
        }
        OrderDTO savedOrder = orderServiceImpl.createOrder(order, orderProductDTOList);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

    }
//    Get Mapping to get all order list details for that customer

//    Get Mapping for detail of single order

//    Change status of order Status from one state to another


}

