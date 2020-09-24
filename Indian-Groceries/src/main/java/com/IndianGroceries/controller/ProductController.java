package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	 
	     @RequestMapping(value = "/allProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	     public ResponseEntity<List<Product>> getAllProducts() {
	    	 System.out.println("Entered get all products");
	    	 List<Product> products=productService.getAllProducts();
	    	
	    	 if(products!=null) {
	         return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	    	 }
	    	 else
	    		 return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	     }
	 
	     @RequestMapping(value = "/addProduct", method = RequestMethod.POST,
	             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	     @ResponseBody()
	     public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
	         return new ResponseEntity<Product>(this.productService.addProduct(product),HttpStatus.CREATED);
	     }
	     
	     @RequestMapping(value = "/updatePrice", method = RequestMethod.PUT,
	             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	     @ResponseBody()
	     public ResponseEntity<Product> updatePrice(@RequestBody String product_id,float new_price) {
	    	Product product=this.productService.updatePrice(product_id, new_price);
	    	 if(product!=null) {
	    		return new ResponseEntity<Product>(product,HttpStatus.OK);
	    	}
	    	 else
	    		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	     }
	     
	     @RequestMapping(value="/deleteProduct", method = RequestMethod.DELETE)
	     @ResponseBody()
	     public ResponseEntity<String> deleteProduct(String product_id){
	    	 String response=this.productService.deleteProduct(product_id);
	    	 if(response.equals("deleted")) {
	    		 return new ResponseEntity<String>(HttpStatus.OK);
	    	 }
	    	 else
	    		 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	     }
	
}
