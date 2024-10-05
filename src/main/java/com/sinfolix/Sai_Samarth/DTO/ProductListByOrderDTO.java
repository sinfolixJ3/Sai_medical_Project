package com.sinfolix.Sai_Samarth.DTO;

import com.sinfolix.Sai_Samarth.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListByOrderDTO {
    private List<ProductQuantityDTO> productQuantity;
    private Optional<Order> order;

    public void setOrder(Optional<Order> order) {
        this.order = order;
    }

}
