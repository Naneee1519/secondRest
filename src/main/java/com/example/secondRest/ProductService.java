package com.example.secondRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ProductEntity> convertProductDTOs(List<ProductDTO> productDTOs) {
        List<ProductEntity> productEntities = new ArrayList<>();

        for (ProductDTO productDTO : productDTOs) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDTO.getName());
            productEntity.setCost(productDTO.getCost());
            productEntity.setDiscount(productDTO.getDiscount());
            productEntity.setProductImageUrl(productDTO.getProductImageUrl());
            productEntity.setCategory_id(productDTO.getCategory_id());
            productEntities.add(productEntity);
        }
        return productEntities;
    }


    public List<ProductEntity> saveProducts(List<ProductEntity> productEntities) {
        return productRepo.saveAll(productEntities);
    }


    public void deleteProductById (Long id){

        productRepo.deleteById(id);
    }

    public Optional <ProductEntity> getProductById(Long productId){

        return productRepo.findById(productId);
    }

//    public List<ProductEntity> getProductsByCategoryId(Long category_id){
//        return productRepo.findByCategoryId(category_id);
//    }

}
