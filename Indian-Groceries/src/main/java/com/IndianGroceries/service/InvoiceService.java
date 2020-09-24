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
    public Invoice addInvoiceRecord(Invoice invoice) {
        return this.invoiceDao.save(invoice);
    }
    
    //Retrieving Invoice by invoice_num
    public List<Invoice> getInvoiceByNum(String invoice_num) {
    	List<Invoice> invoiceByNum=new ArrayList<Invoice>();
    	for(Invoice i : invoiceDao.findAll()) {
    		if(i.getInvoice_num().equals(invoice_num)) {
    			invoiceByNum.add(i);
    		}
    	}
    	return invoiceByNum;
    }
    
    
    

}
