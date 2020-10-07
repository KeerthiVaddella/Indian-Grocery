package com.IndianGroceries.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IndianGroceries.dao.InvoiceDao;
import com.IndianGroceries.entity.Invoice;

@Service
public class InvoiceService {
	
	@Autowired
    InvoiceDao invoiceDao;

    //Add a new product
    public String addInvoiceRecord(List<Invoice> invoice) {
    	if(invoice != null) {
    		for(Invoice i : invoice) {
    			this.invoiceDao.save(i);
    		}
    		return "added";
    	}
    	else return "invalid entry";
    }
    
    private List<Invoice> getAll(){
    	
    	return this.invoiceDao.findAll();
    }
    //Retrieving Invoice by invoice_num
    public List<Invoice> getInvoiceByNum(String invoice_num) {
    	List<Invoice> invoiceByNum=new ArrayList<Invoice>();
    	for(Invoice i : this.getAll()) {
    		if(i.getInvoice_num().equals(invoice_num)) {
    			invoiceByNum.add(i);
    		}
    	}
    	return invoiceByNum;
    }
    
    public List<Invoice> getBuyerOrders(Long buyer_id){
    	List<Invoice> buyerOrders= new ArrayList<Invoice>();
    	for(Invoice i : this.getAll()) {
    		if(i.getBuyer_id()==buyer_id){
    			buyerOrders.add(i);
    		}
    	}
    	return buyerOrders;
    }
    
    

}
