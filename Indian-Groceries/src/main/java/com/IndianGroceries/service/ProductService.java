package com.IndianGroceries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    //Update Price of the product
    public Boolean updatePrice(String product_id,float new_price) {
    	List<Product> products=this.getAllProducts();
    	Boolean success=false;
    	for(Product p : products) {
    		if(p.getProduct_id().equals(product_id)) {
    			p.setPrice(new_price);
    			this.productDao.save(p);
    			success=true;
    		}
    	}
    	return success;
    	
    }
    
}