package com.example.secondRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flazon/api")
public class Controller {

	UserService userService;

	@Autowired
	UserRepo userRepo;

	ProductService productService;
	@Autowired
	ProductRepo productRepo;



	Controller(UserRepo userRepo, ProductRepo productRepo){

		this.userService = new UserService(userRepo);
		this.productService = new ProductService(productRepo);
	}


	@PostMapping("user/create")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
		try {
			return  ResponseEntity.ok(userService.convertUserDTO(userDTO));
		}catch (Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
			errorResponse.message = "Duplicate User Found";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

	}

//	@PostMapping("product/create")
//	public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
//		try {
//			return ResponseEntity.ok(productService.convertsProductDTO(productDTO));
//		}catch (Exception e){
//			ErrorResponse errorResponse = new ErrorResponse();
//			errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
//			errorResponse.message = "Duplicate Product Found";
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//		}
//	}

	@PostMapping("products/create")
	public ResponseEntity<?> createProduct(@RequestBody List<ProductEntity> productDTOList){
		try {
			List<ProductEntity> productEntities = productService.convertProductDTOs(productDTOList);
			List<ProductEntity> savedProducts = productService.createProducts(productEntities);
			return ResponseEntity.ok(savedProducts);
		}catch (Exception e){
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.statusCode = HttpStatus.BAD_REQUEST.toString();
			errorResponse.message = "Duplicate Product Found";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
}
