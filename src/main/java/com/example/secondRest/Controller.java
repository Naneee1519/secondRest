package com.example.secondRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("flazonapi")
public class Controller {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    AppRepo appRepo;


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




    Controller(ProductRepo productRepo, FilmRepo filmRepo, AppRepo appRepo,CategoryRepo categoryRepo,  UserRepo userRepo, HeroRepo heroRepo ) {
        this.appRepo = appRepo;
        this.productRepo = productRepo;
        this.filmRepo = filmRepo;
        this.heroRepo = heroRepo;
        this.userService = new UserService(userRepo);
        this.categoryService = new CategoryService(categoryRepo);
    }

    @GetMapping("app/getOwnerList")
    public List<AppEntity> getAllOwnerList() {

        return appRepo.findAll();
    }


    @GetMapping("film/getList")
    public List<FilmEntity> getAllFilmList() {
        System.out.println("MoviesList Calling");
        return filmRepo.findAll();
    }


    @GetMapping("product/getAllList")
    public List<ProductEntity> getAllProductList() {
        return productRepo.findAll();
    }


    @GetMapping("film/getAllHerosList")
    public List<HeroEntity> getAllHeroList() {
        return heroRepo.findAll();
    }

//    @PostMapping("user/create")
//    public UserEntity createUser(@RequestBody UserEntity userEntity ){
//        return userRepo.save(userEntity);
//    }

    @PostMapping("user/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        try{
            return ResponseEntity.ok(userService.convertUserDTO(userDTO));
        }catch (Exception e){
          System.out.println(e.getMessage() +"Rahul");
            String errorMessage = "Failed to create user: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping("user/Allcategory")
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

    }


