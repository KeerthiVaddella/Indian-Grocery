package com.IndianGroceries.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCTS")
public class Product {
		@Id
		@GenericGenerator(
		        name = "id-sequence",
		        strategy = "com.IndianGroceries.entity.StringSequenceIdentifier"
		       /* ,parameters = {
		            @org.hibernate.annotations.Parameter(
		                name = "sequence_name", value = "hibernate_sequence"),
		            @org.hibernate.annotations.Parameter(
		                name = "sequence_prefix", value = "IG_"),
		        }*/
		    )
		@GeneratedValue(generator="id-sequence",strategy = GenerationType.SEQUENCE)
		//@Column(name="PRODUCT_ID")
		private String product_id;
		
		@Column(name="DESCRIPTION")
		private String description;
		
		//@Column(name="PRICE")
		private float price;
		
		public Product() {
			
		}
		
		public Product(String product_id,String description,float price) {
			this.product_id=product_id;
			this.description=description;
			this.price=price;
		}
		public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}
		
		
}
