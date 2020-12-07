package com.IndianGroceries.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IndianGroceries.dao.BuyerDao;
import com.IndianGroceries.entity.Buyer;


@Service
public class BuyerService {

	@Autowired
	BuyerDao buyerDao;
	
	//Add a new buyer
    public String addBuyer(Buyer buyer) {
    	Buyer buyer2=this.buyerDao.findByAddress(buyer.getAddress());
    	if(buyer2!=null)
    		return "Address Already Exists";
	
    	this.buyerDao.save(buyer);
        return "Added";
    }
	
    //Gets all the products from the DB
    public List<Buyer> getAllBuyers() {
    	System.out.println("Entered BuyerService getAllBuyers()");
    	List<Buyer> p=this.buyerDao.findAll();
    	Collections.sort(p,new BuyerCompare());
    	System.out.println(p);
        return p;
    }
    
    public Buyer getBuyerById(Long buyer_id) {
    	Buyer buyerById=null;
    	List<Buyer> buyers=buyerDao.findAll();
    	for(Buyer b : buyers) {
    		if(b.getBuyer_id()==buyer_id) {
    			buyerById=b;
       		}
    	}
    	return buyerById;
    }
	
    
    //Update Buyer Details
    public String updateBuyer(Buyer buyer) {
    	for(Buyer b: buyerDao.findAll()) {
    		if(b.getBuyer_id()!=buyer.getBuyer_id() && b.getAddress().contentEquals(buyer.getAddress())) {
    			return "Address Already Exists";
    		}
    	}
    	Buyer b1=getBuyerById(buyer.getBuyer_id());
    	if(b1!=null) {
    		b1.updateBuyer(buyer.getBuyer_name(),buyer.getAddress(),buyer.getGstin());
    		this.buyerDao.save(b1);
    	}
    	return "Updated";
    }
    
    //Delete Buyer
    public String deleteBuyer(Long buyer_id) {
    	
    	Buyer b=getBuyerById(buyer_id);
    	if(b!=null) {
    		this.buyerDao.delete(b);
    		return "Deleted";
    	}
    	return "Not Found";
    }
    
    
}

class BuyerCompare implements Comparator<Buyer>{

	@Override
	public int compare(Buyer o1, Buyer o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getBuyer_id()-o2.getBuyer_id());
	}

	
	
}

