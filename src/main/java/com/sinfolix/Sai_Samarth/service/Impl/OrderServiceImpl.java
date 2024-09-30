package com.sinfolix.Sai_Samarth.service.Impl;

import com.sinfolix.Sai_Samarth.DTO.OrderDTO;
import com.sinfolix.Sai_Samarth.DTO.OrderProductDTO;
import com.sinfolix.Sai_Samarth.entities.Order;
import com.sinfolix.Sai_Samarth.entities.OrderProduct;
import com.sinfolix.Sai_Samarth.exceptions.ResourceNotFoundException;
import com.sinfolix.Sai_Samarth.repositories.OrderProductRepository;
import com.sinfolix.Sai_Samarth.repositories.OrderRepository;
import com.sinfolix.Sai_Samarth.repositories.ProductCatlogueRepo;
import com.sinfolix.Sai_Samarth.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductCatlogueRepo productCatlogueRepo;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO, List<OrderProductDTO> orderProductDTOList) {
        Order order = new Order();
//        Set order Properties
        order.setCustomerName(orderDTO.getCustomerName());
        order.setCustomerEmail(orderDTO.getCustomerEmail());
        order.setCustomerAddress(orderDTO.getCustomerAddress());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setModified_time(orderDTO.getModified_time());
        order.setStatus(orderDTO.getStatus());

        Order savedOrder = orderRepository.save(order);

        for (OrderProductDTO orderProductDTO : orderProductDTOList) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(savedOrder);
            orderProduct.setProductCatlogue(productCatlogueRepo.findById(orderProductDTO.getProductCatlogue().getId()).orElseThrow(() -> new ResourceNotFoundException("Product Catlogue", "ID ", orderProductDTO.getProductCatlogue().getId())));
            orderProduct.setQuantity(orderProductDTO.getQuantity());
            orderProductRepository.save(orderProduct);
        }
        return OrderToOrderDTO(savedOrder);
    }

    @Override
    public List<OrderDTO> getOrderListByCustomerEmail(String customerEmail) {
        return List.of();
    }

    @Override
    public OrderDTO getOrderById(int orderId) {
        return null;
    }

    private OrderDTO OrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName(order.getCustomerName());
        orderDTO.setCustomerEmail(order.getCustomerEmail());
        orderDTO.setCustomerAddress(order.getCustomerAddress());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setModified_time(order.getModified_time());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;

    }
}

