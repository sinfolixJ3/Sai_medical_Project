package com.sinfolix.Sai_Samarth.DTO;

import com.sinfolix.Sai_Samarth.entities.ProductCatlogue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantityDTO {
    private int quantity;
    private Optional<ProductCatlogue> product_catlogie;

    public void setProduct_catlogie(Optional<ProductCatlogue> product_catlogie) {
        this.product_catlogie = product_catlogie;
    }
}
