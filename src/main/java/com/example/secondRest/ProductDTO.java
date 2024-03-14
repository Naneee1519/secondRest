package com.example.secondRest;

public class ProductDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public int getDiscount() {

        return discount;
    }

    public void setDiscount(int discount) {

        this.discount = discount;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
