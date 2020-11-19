package com.IndianGroceries.service;

import java.util.Collections;
import java.util.Comparator;
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
    	System.out.println("Entered ProductService getAllProducts()");
    	List<Product> p=this.productDao.findAll();
    	Collections.sort(p,new ProductCompare());
    	//System.out.println(p);
        return p;
    }

    //Add a new product
    public Product addProduct(Product product) {
        return this.productDao.save(product);
    }
    
   public Product getProductById(String product_id) {
    	Product productById=null;
    	for(Product p : productDao.findAll()) {
    		if(p.getProduct_id().equals(product_id)) {
    			productById=p;
    		}
    	}
    	return productById;
    }
    
    
    //Update Price of the product
    public Product updateProduct(String product_id,Product product) {
    		Product p=getProductById(product_id);
    		System.out.println("Found product");
     		if(p!=null) {
    			p.setPrice(product.getPrice());
    			p.setDescription(product.getDescription());
    			this.productDao.save(p);
    			  			
    		}
    	return p;   	
    }

    
    //Delete a Product based on the id
    public String deleteProduct(String product_id){
    	Product p=getProductById(product_id);
    	
    	
    	if(p!=null) {
    		System.out.println("Found product");
    		this.productDao.delete(p);
    		System.out.println("Deleted");
    		return "deleted";
    	}
    	return "notFound";
    }
    
}

class ProductCompare implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getProduct_id().compareTo(o2.getProduct_id());
	}
	
}
