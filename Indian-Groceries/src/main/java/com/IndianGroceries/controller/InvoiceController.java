package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.IndianGroceries.entity.Invoice;
import com.IndianGroceries.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	 @Autowired
	 InvoiceService invoiceService;
	 
	 @RequestMapping(value = "/invoiceByNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Invoice>> getInvoiceByNumber(String invoice_num){
		 List<Invoice> invoice=this.invoiceService.getInvoiceByNum(invoice_num);
		 
		 if(invoice!=null) {
			 return new ResponseEntity<List<Invoice>>(invoice,HttpStatus.OK);
		 }
		 else
			 return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @RequestMapping(value = "/addInvoiceEntry", method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
	 public ResponseEntity<Invoice> addInvoiceEntry(Invoice invoice){
		 
		 return new ResponseEntity<Invoice>(this.invoiceService.addInvoiceRecord(invoice),HttpStatus.CREATED);
		 
	 }
}
