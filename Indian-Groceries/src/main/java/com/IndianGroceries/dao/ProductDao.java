package com.IndianGroceries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IndianGroceries.entity.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
		
}