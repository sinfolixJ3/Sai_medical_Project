package com.sinfolix.Sai_Samarth.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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



}
