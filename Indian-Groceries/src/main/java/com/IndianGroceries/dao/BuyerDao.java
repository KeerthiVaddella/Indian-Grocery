package com.IndianGroceries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IndianGroceries.entity.Buyer;


@Repository
public interface BuyerDao extends JpaRepository<Buyer, Integer> {
}