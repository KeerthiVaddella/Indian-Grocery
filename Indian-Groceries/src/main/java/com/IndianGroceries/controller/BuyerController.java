package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IndianGroceries.entity.Buyer;
import com.IndianGroceries.service.BuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	
	@GetMapping("/allBuyers")
	//@RequestMapping(value = "/allBuyerss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Buyer>> getBuyers() {
		List<Buyer> buyers = buyerService.getAllBuyers();
		if (buyers != null) {
			return new ResponseEntity<List<Buyer>>(buyers, HttpStatus.OK);
		} else
			return new ResponseEntity<List<Buyer>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/addBuyer")
	public ResponseEntity<String> addBuyer(@RequestBody Buyer buyer) {
		String added = buyerService.addBuyer(buyer);
		if (added.equalsIgnoreCase("added")) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.FAILED_DEPENDENCY);
	}

	@PutMapping("/updateBuyer")
	public ResponseEntity<String> updateBuyer(@RequestBody Buyer buyer) {

		String updated = buyerService.updateBuyer(buyer);
		if (updated.equalsIgnoreCase("updated")) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.FAILED_DEPENDENCY);
	}


	@DeleteMapping("/deleteBuyer/{buyer_id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("buyer_id") Long buyer_id) {

		System.out.println("Trying to delete re..." + buyer_id);
		String response = this.buyerService.deleteBuyer(buyer_id);

		if (response.equalsIgnoreCase("deleted")) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
