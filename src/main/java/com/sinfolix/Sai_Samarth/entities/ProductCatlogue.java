package com.sinfolix.Sai_Samarth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product_catlogue")
@Data
public class ProductCatlogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "discount", nullable = false)
    private int discount;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;


    @Column(name = "minAge", nullable = false)
    private int minAge;

    @Column(name = "maxAge", nullable = false)
    private int maxAge;

    @Column(name = "real_mrp", nullable = false)
    private int realMrp;

    @Column(name = "discount_mpr", nullable = false)
    private int discountMpr;

    @OneToMany(mappedBy = "productCatlogue", fetch = FetchType.EAGER)
    @JsonIgnore  // Prevents lazy loading proxies from being serialized
    private List<OrderProduct> orderProducts;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;


    public boolean getEnabled() {
        return enabled;
    }
}
