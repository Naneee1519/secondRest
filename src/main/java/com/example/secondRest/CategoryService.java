package com.example.secondRest;

public class CategoryService {

    CategoryRepo categoryRepo;

            CategoryService(CategoryRepo categoryRepo){

        this.categoryRepo =categoryRepo;

            }

            public CategoryEntity convertCategoryDTO(CategoryDTO categoryDTO){
                try{
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setName(categoryDTO.getName());
                    categoryEntity.setCategory_id(categoryDTO.getCategory_id());

                    return categoryRepo.save(categoryEntity);

                }catch( Exception e){
                    throw e;
                }

            }

            public void deleteCategoryById(Long category_id){
                categoryRepo.deleteById(category_id);
            }

}
