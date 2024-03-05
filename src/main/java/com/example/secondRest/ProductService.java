package com.example.secondRest;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    ProductRepo productRepo;

    ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

//    public ProductEntity convertsProductDTO(ProductDTO productDTO){
//        try {
//            ProductEntity productEntity = new ProductEntity();
//            productEntity.setName(productDTO.getName());
//            productEntity.setCost(productDTO.getCost());
//            productEntity.setDiscount(productDTO.getDiscount());
//            productEntity.setProduct_Image_url(productDTO.getProduct_Image_url());
//            productEntity.setCategory_id(productDTO.getCategory_id());
//            return productRepo.save(productEntity);
//        } catch (Exception e){
//            throw e;
//    }

    public List<ProductEntity> convertProductDTOs(List<ProductEntity> productDTOs){
        List<ProductEntity> productEntities = new ArrayList<>();

        for (ProductEntity productDTO : productDTOs){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDTO.getName());
            productEntity.setCost(productDTO.getCost());
            productEntity.setDiscount(productDTO.getDiscount());
            productEntity.setProduct_Image_url(productDTO.getProduct_Image_url());
            productEntity.setCategory_id(productDTO.getCategory_id());

            productEntities.add(productEntity);
        }
        return productEntities;
    }


    public List<ProductEntity> createProducts(List<ProductEntity> productDTOs) {
        List<ProductEntity> productEntities = convertProductDTOs(productDTOs);

        return productRepo.saveAll(productEntities);
    }
}
