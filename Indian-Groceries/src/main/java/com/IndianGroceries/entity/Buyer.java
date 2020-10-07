package com.IndianGroceries.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "BUYER")
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long buyer_id;

	private String buyer_name;

	@Column(name = "ADDRESS")
	private String address;

	private String gstin;
	
	
	
	// no agrs constructor
	public Buyer() {
	}

	// argumented constructor
	public Buyer(long buyer_id, String buyer_name, String address, String gstin) {
		this.buyer_id = buyer_id;
		this.buyer_name = buyer_name;
		this.address = address;
		this.gstin = gstin;
	}
	
	public void updateBuyer(String buyer_name,String address,String gstin) {
		this.buyer_name=buyer_name;
		this.address = address;
		this.gstin = gstin;
	}
	
	public long getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

}
