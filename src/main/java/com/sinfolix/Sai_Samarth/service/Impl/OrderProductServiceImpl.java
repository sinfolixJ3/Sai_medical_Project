package com.sinfolix.Sai_Samarth.service.Impl;

import com.sinfolix.Sai_Samarth.DTO.ProductListByOrderDTO;
import com.sinfolix.Sai_Samarth.DTO.ProductQuantityDTO;
import com.sinfolix.Sai_Samarth.entities.Order;
import com.sinfolix.Sai_Samarth.entities.OrderProduct;
import com.sinfolix.Sai_Samarth.entities.ProductCatlogue;
import com.sinfolix.Sai_Samarth.exceptions.ResourceNotFoundException;
import com.sinfolix.Sai_Samarth.repositories.OrderProductRepository;
import com.sinfolix.Sai_Samarth.repositories.OrderRepository;
import com.sinfolix.Sai_Samarth.repositories.ProductCatlogueRepo;
import com.sinfolix.Sai_Samarth.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductCatlogueRepo productCatlogueRepo;

    @Override
    public ProductListByOrderDTO getProductListByOrderId(long orderId) {

        List<OrderProduct> orderProducts = orderProductRepository.findByOrderId(orderId);
        if (!orderProducts.isEmpty()) {
            ProductListByOrderDTO productListByOrderDTO = new ProductListByOrderDTO();
            int order_id = Math.toIntExact(orderProducts.get(0).getOrder().getId());
            Optional<Order> order = Optional.ofNullable(orderRepository.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Product Catlogue", "ID ", order_id)));
            productListByOrderDTO.setOrder(order);
            List<ProductQuantityDTO> productQuantityList = new ArrayList<>();
            for (OrderProduct productQuantity : orderProducts) {
                ProductQuantityDTO productQuantitymap = new ProductQuantityDTO();
                productQuantitymap.setQuantity(productQuantity.getQuantity());
                int productCatlogueId = productQuantity.getProductCatlogue().getId();
                Optional<ProductCatlogue> productCatlogue = productCatlogueRepo.findById(productCatlogueId);

                productQuantitymap.setProduct_catlogie(productCatlogue);
                productQuantityList.add(productQuantitymap);
            }
            productListByOrderDTO.setProductQuantity(productQuantityList);
            return productListByOrderDTO;

        }
//             through exception
        throw new ResourceNotFoundException("Order Product table", "order id", orderId);

    }

    //    getProductListByEmailId
    @Override
    public List<ProductListByOrderDTO> getProductListByEmailId(String email_id) {

        List<Order> orderList = orderRepository.findByCustomerEmail(email_id);
        List<ProductListByOrderDTO> productList = new ArrayList<>();
        for (Order order : orderList) {
            long orderId = order.getId();
            ProductListByOrderDTO productListByOrderDTO = getProductListByOrderId(orderId);
            productList.add(productListByOrderDTO);
        }
        return productList;

    }


}
