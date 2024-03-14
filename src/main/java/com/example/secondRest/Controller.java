package com.example.secondRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("flazon/api")
public class Controller {
//    @Autowired
//    AppRepo appRepo;

    @Autowired
    FilmRepo filmRepo;

    @Autowired
    UserRepo userRepo;

    UserService userService;

    @Autowired
    CategoryRepo categoryRepo;
    CategoryService categoryService;

    @Autowired
    HeroRepo heroRepo;

    ProductService productService;
    @Autowired
    ProductRepo productRepo;


    Controller(ProductRepo productRepo, FilmRepo filmRepo,CategoryRepo categoryRepo,  UserRepo userRepo, HeroRepo heroRepo ) {
//        this.appRepo = appRepo;
        this.productRepo = productRepo;
        this.filmRepo = filmRepo;
        this.heroRepo = heroRepo;
        this.userService = new UserService(userRepo);
        this.categoryService = new CategoryService(categoryRepo);
        this.productService = new ProductService(productRepo);
    }


    @GetMapping("film/getList")
    public List<FilmEntity> getAllFilmList() {
        System.out.println("MoviesList Calling");
        return filmRepo.findAll();
    }


    @GetMapping("film/getAllHerosList")
    public List<HeroEntity> getAllHeroList() {

        return heroRepo.findAll();
    }

    @PostMapping("user/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        try{
            return ResponseEntity.ok(userService.convertUserDTO(userDTO));
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
            errorResponse.message = "Duplicate Found";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.message);
        }
    }

    @GetMapping("user/all")
    public List<UserEntity> getAllUsersList() {
        return userRepo.findAll();
    }

    @GetMapping("category/getAllList")
    public List<CategoryEntity> getAllCategoryList(){

        return categoryRepo.findAll();
    }

    @PostMapping("user/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        try{
            return ResponseEntity.ok(categoryService.convertCategoryDTO(categoryDTO));
        }catch(Exception e){
            System.out.println(e.getMessage() +"Rahul");
            String errorMessage = "Failed to create user: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);

        }

    }

    @PostMapping("category/deleteByID")
    public ResponseEntity<?> deleteCategoryById(@RequestBody Map<String, Long> requestBody){
        Long category_id = requestBody.get("category_id");
        try{
            categoryService.deleteCategoryById(category_id);
            return ResponseEntity.ok("Category with this ID " + category_id + " has been deleted successfully");
        } catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
            errorResponse.message = "Category not found by this " + category_id;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.message);
        }
    }


    @GetMapping("product/getAllList")
    public List<ProductEntity> getAllProductList() {

        return productRepo.findAll();
    }

    @PostMapping("product/deleteById")
    public ResponseEntity<?> deleteProductId(@RequestBody Map<String, Long> requestBody) {

        Long productId = requestBody.get("id");
        try{
            productService.deleteProductById(productId);
            return ResponseEntity.ok("Product with ID " + productId + " has been deleted successfully.");
        } catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
            errorResponse.message = "Product not Found with this " + productId;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.message);
        }
    }


    @PostMapping("products/create")
    public ResponseEntity<?> createProducts(@RequestBody List<ProductDTO> productDTOList) {
        try {
            List<ProductEntity> productEntities = productService.convertProductDTOs(productDTOList);
            List<ProductEntity> savedProducts = productService.saveProducts(productEntities);
            return ResponseEntity.ok(savedProducts);
        } catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
            errorResponse.message = "Duplicate Product Found";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


    @PostMapping("product/basedOnProductId")
    public ResponseEntity<ProductEntity> getProductId(@RequestBody Map<String, Long> requestBody){
        Long productId = requestBody.get("productId");

        Optional<ProductEntity> product = productService.getProductById(productId);
        if (product.isPresent()){
            return ResponseEntity.ok(product.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


//    @PostMapping("product/ByCategoryId/{category_id}")
//
//    public ResponseEntity<List<ProductEntity>> getProductsByCategoryId(@RequestBody Map<String, Long> requsteBody){
//        Long category_id = requsteBody.get("category_id");
//        List<ProductEntity> productEntities = productService.getProductsByCategoryId(category_id);
//
//        if (productEntities.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(productEntities);
//    }

//    @PostMapping("products/byCategory")
//    public ResponseEntity<List<ProductEntity>> getProductsByCategoryId(@RequestBody ProductDTO productDTO) {
//        Long categoryId = productDTO.getCategory_id();
//        List<ProductEntity> productEntities = productService.getProductsByCategoryId(categoryId);
//        return ResponseEntity.ok(productEntities);
//    }

}


