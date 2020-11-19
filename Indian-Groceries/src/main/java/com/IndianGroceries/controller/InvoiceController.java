package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IndianGroceries.entity.Invoice;
import com.IndianGroceries.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	 @Autowired
	 InvoiceService invoiceService;
	 
	 @GetMapping("/invoiceByNumber/{invoice_num}")
	 public ResponseEntity<List<Invoice>> getInvoiceByNumber(@PathVariable String invoice_num){
		 List<Invoice> invoice=this.invoiceService.getInvoiceByNum(invoice_num);
		 
		 if(invoice!=null) {
			 return new ResponseEntity<List<Invoice>>(invoice,HttpStatus.OK);
		 }
		 else
			 return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @PostMapping("/addInvoiceEntry")
	 public ResponseEntity<String> addInvoiceEntry(@RequestBody List<Invoice> invoice){
		 String added=this.invoiceService.addInvoiceRecord(invoice);
		 if(added.equalsIgnoreCase("added")) {
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }
		 else
		 return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
		 
	 }
	 
	 @GetMapping("/invoiceByBuyer/{buyer_id}")
	 public ResponseEntity<List<Invoice>> getInvoiceByBuyer(@PathVariable Long buyer_id){
		 List<Invoice> invoice=this.invoiceService.getBuyerOrders(buyer_id);
		 if(invoice!=null) {
			 return new ResponseEntity<List<Invoice>>(invoice,HttpStatus.OK);
		 }
		 else
			 return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
		 
	 }
}
