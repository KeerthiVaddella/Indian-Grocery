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

    public List<Product> getAllProducts() {
        return this.productDao.findAll();
    }

    public Product addProduct(Product product) {
        return this.productDao.save(product);
    }

    
}