package com.sinfolix.Sai_Samarth.DTO;

import lombok.Data;

@Data
public class ProductCatlogueDTO {

    private int id;

    private int quantity;

    private int price;

    private int discount;

    private String companyName;

    private String medicineName;


    private int minAge;

    private int maxAge;

    private int realMrp;

    private int discountMrp;

    private boolean enabled;


    public boolean getEnabled() {
        return enabled;
    }
}
