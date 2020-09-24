package com.IndianGroceries.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE")
public class Invoice {
		
		@Id
		@Column(name="INVOICE_NUM",nullable=false)
		private String invoice_num;
		
		private Date order_date;
		
		@ManyToOne(targetEntity = Buyer.class)
		@JoinColumn(name="BUYER_ID")
		private long buyer_id;
		
		@ManyToOne(targetEntity = Product.class)
		@JoinColumn(name="PRODUCT_ID")
		private String product_id;
		
		@Column(name="PACKAGE")
		private String package_type;
		
		private int quantity;
		private int freepacks;
		
		private float distributor_price;
		private float selling_price;
		private float tax;
		private double amount;
		
		public Invoice() {
			
		}
		
		public Invoice(String invoice_num,Date order_date,long buyer_id,String product_id,String package_type,int quantity,int freepacks,
				float distributor_price,float selling_price,float tax,double amount) {
			//if needed
		}
		public String getInvoice_num() {
			return invoice_num;
		}
		public void setInvoice_num(String invoice_num) {
			this.invoice_num = invoice_num;
		}
		public Date getOrder_date() {
			return order_date;
		}
		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}
		public long getBuyer_id() {
			return buyer_id;
		}
		public void setBuyer_id(long buyer_id) {
			this.buyer_id = buyer_id;
		}
		public String getProduct_id() {
			return product_id;
		}
		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}
		public String getPackage_type() {
			return package_type;
		}
		public void setPackage_type(String package_type) {
			this.package_type = package_type;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getFreepacks() {
			return freepacks;
		}
		public void setFreepacks(int freepacks) {
			this.freepacks = freepacks;
		}
		public float getDistributor_price() {
			return distributor_price;
		}
		public void setDistributor_price(float distributor_price) {
			this.distributor_price = distributor_price;
		}
		public float getSelling_price() {
			return selling_price;
		}
		public void setSelling_price(float selling_price) {
			this.selling_price = selling_price;
		}
		public float getTax() {
			return tax;
		}
		public void setTax(float tax) {
			this.tax = tax;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		
}
