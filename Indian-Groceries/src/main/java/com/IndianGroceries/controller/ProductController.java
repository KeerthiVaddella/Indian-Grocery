package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.IndianGroceries.service.ProductService;
import com.IndianGroceries.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	     @Autowired
	     ProductService productService;
	 
	     @RequestMapping(value = "/all", method = RequestMethod.GET)
	     public List<Product> getAllProducts() {
	         return productService.getAllProducts();
	     }
	 
	     @RequestMapping(value = "/addproduct", method = RequestMethod.POST,
	             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	     @ResponseBody()
	     public Product addNewUser(@RequestBody Product product) {
	         return this.productService.addProduct(product);
	     }
	     
	     //other controllers omitted for brevity
	 

	
}
