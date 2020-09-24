package com.IndianGroceries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.IndianGroceries.dao.ProductDao;
import com.IndianGroceries.entity.Product;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    //Gets all the products from the DB
    public List<Product> getAllProducts() {
        return this.productDao.findAll();
    }

    //Add a new product
    public Product addProduct(Product product) {
        return this.productDao.save(product);
    }
    
    private Product getProductById(String product_id) {
    	Product productById=null;
    	for(Product p : productDao.findAll()) {
    		if(p.getProduct_id().equals(product_id)) {
    			productById=p;
    		}
    	}
    	return productById;
    }
    
    
    //Update Price of the product
    public Product updatePrice(String product_id,float new_price) {
    		Product p=getProductById(product_id);
     		if(p!=null) {
    			p.setPrice(new_price);
    			this.productDao.save(p);
    			  			
    		}
    	return p;   	
    }

    
    //Delete a Product based on the id
    public String deleteProduct(String product_id){
    	Product p=getProductById(product_id);
    	if(p!=null) {
    		this.productDao.delete(p);
    		return "deleted";
    	}
    	return "notFound";
    }
    
}