package com.example.secondRest;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;

    private Long cost;

    private int discount;

    private String productImageUrl;

    private Long category_id;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getCost() {

        return cost;
    }

    public void setCost(Long cost) {

        this.cost = cost;
    }

    public int getDiscount() {

        return discount;
    }

    public void setDiscount(int discount) {

        this.discount = discount;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }


    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
