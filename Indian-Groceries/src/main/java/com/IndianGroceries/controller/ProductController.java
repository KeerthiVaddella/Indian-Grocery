package com.IndianGroceries.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IndianGroceries.service.ProductService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import com.IndianGroceries.entity.Product;

@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/product")
public class ProductController {

	     @Autowired
	     ProductService productService;
	 
	     @GetMapping("/allProducts")
	     public ResponseEntity<List<Product>> getAllProducts() {
	    	 System.out.println("Entered get all products");
	    	 List<Product> products=productService.getAllProducts();
	    	
	    	 if(products!=null) {
	    		 for(Product p : products) {
	    		 System.out.println(p.getProduct_id());
	    		 }
	    		 return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	         
	    	 }
	    	 else
	    		 return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	     }
	 
	     @PostMapping("/addProduct")
	     public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
	         return new ResponseEntity<Product>(this.productService.addProduct(product),HttpStatus.CREATED);
	     }
	     
	     @PutMapping("/updateProduct/{product_id}")
	     public ResponseEntity<Product> updatePrice(@PathVariable("product_id") String product_id,@RequestBody Product product) {
	    	System.out.println(product_id+" & "+product);
	    	 Product product1=this.productService.updateProduct(product_id,product);
	    	 if(product1!=null) {
	    		return new ResponseEntity<Product>(product1,HttpStatus.OK);
	    	}
	    	 else
	    		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	     }
	     
	     @DeleteMapping("/deleteProduct/{product_id}")
	     public ResponseEntity<JSONObject> deleteProduct(@PathVariable("product_id") String product_id){
	    	 JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
	    	 System.out.println("Trying to delete re..."+ product_id);
	    	 String response=this.productService.deleteProduct(product_id);
	    	 try {
	 			if (response.equalsIgnoreCase("deleted")) {
	 				response="{'response':"+response+"}";
	 				return ResponseEntity.ok((JSONObject)parser.parse(response));
	 				
	 			} else {
	 				response="{'response':"+response+"}";
	 				return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body((JSONObject)parser.parse(response));			
	 			}
	 			}
	 			catch(ParseException pe) {
	 				System.out.println("Something happened while converting to JSON");
	 			}
	 			return null;
	 			}
	     @GetMapping("/getProductName/{product_id}")
	     public ResponseEntity<Product> getProductById(@PathVariable("product_id") String product_id){
	    	 Product product=this.productService.getProductById(product_id);
	    	 if(product!=null)
	    		 return new ResponseEntity<Product>(product,HttpStatus.OK);
	    	 else
	    		 return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	     }
}
