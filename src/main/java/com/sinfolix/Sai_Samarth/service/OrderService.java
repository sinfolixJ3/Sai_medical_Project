package com.sinfolix.Sai_Samarth.service;

import com.sinfolix.Sai_Samarth.DTO.OrderDTO;
import com.sinfolix.Sai_Samarth.DTO.OrderProductDTO;

import java.util.List;

public interface OrderService {

    //    create a new order
    OrderDTO createOrder(OrderDTO orderDTO, List<OrderProductDTO> orderProductDTOList);

    //    Get order List details by Customer email id
    List<OrderDTO> getOrderListByCustomerEmail(String customerEmail);

    //    Get ORder Details by order Id
    OrderDTO getOrderById(int orderId);


}
