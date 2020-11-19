package com.IndianGroceries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

//import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	
	JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
	
	@GetMapping("/allBuyers")
	
	public ResponseEntity<List<Buyer>> getBuyers() {
		List<Buyer> buyers = buyerService.getAllBuyers();
		if (buyers != null) {
			return new ResponseEntity<List<Buyer>>(buyers, HttpStatus.OK);
		} else
			return new ResponseEntity<List<Buyer>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/addBuyer")
	public ResponseEntity<JSONObject> addBuyer(@RequestBody Buyer buyer) {
		System.out.println("entered add buyer"+ buyer.getBuyer_name());
		String added = buyerService.addBuyer(buyer);
		try {
		if (added.equalsIgnoreCase("added")) {
			added="{'response':"+added+"}";
			return ResponseEntity.ok((JSONObject)parser.parse(added));
		} else {
			added="{'response':"+added+"}";
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body((JSONObject)parser.parse(added));
		}
		}catch(ParseException pe){
			System.out.println("Something happened while converting to JSON");
		}
			return null;
	}

	@PutMapping(path="/updateBuyer",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> updateBuyer(@RequestBody Buyer buyer) {
		System.out.println("update buyer controller"+buyer.getBuyer_name());
		String updated = buyerService.updateBuyer(buyer);
		System.out.println(updated);
		try {
		if (updated.equalsIgnoreCase("updated")) {
			System.out.println("Inside Success of Update");
			updated="{'response':"+updated+"}";
			return ResponseEntity.ok((JSONObject)parser.parse(updated));
			
		} else {
			System.out.println(updated);
			updated="{'response':"+updated+"}";
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body((JSONObject)parser.parse(updated));
			
		}
		}
		catch(ParseException pe) {
			System.out.println("Something happened while converting to JSON");
		}
		return null;
		}

	
	@DeleteMapping("/deleteBuyer/{buyer_id}")
	public ResponseEntity<JSONObject> deleteProduct(@PathVariable("buyer_id") Long buyer_id) {

		System.out.println("Trying to delete re..." + buyer_id);
		String response = this.buyerService.deleteBuyer(buyer_id);
		try {
			if (response.equalsIgnoreCase("deleted")) {
				response="{'response':"+response+"}";
				return ResponseEntity.ok((JSONObject)parser.parse(response));
				
			} else {
				response="{'response':"+response+"}";
				return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body((JSONObject)parser.parse(response));			
			}
			}
			catch(ParseException pe) {
				System.out.println("Something happened while converting to JSON");
			}
			return null;
			}

	
	@GetMapping("/getBuyerName/{buyer_id}")
	public ResponseEntity<Buyer> getBuyerName(@PathVariable("buyer_id") Long buyer_id){
		Buyer buyer=this.buyerService.getBuyerById(buyer_id);
		
		if(buyer!=null) {
			
			return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
	}
}
