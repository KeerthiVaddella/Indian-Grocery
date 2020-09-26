package com.IndianGroceries.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
		@Id
		@GenericGenerator(
		        name = "id_sequence",
		        strategy = "com.IndianGroceries.entity.StringSequenceIdentifier",
		       parameters = {
		            @org.hibernate.annotations.Parameter(
		                name = StringSequenceIdentifier.INCREMENT_PARAM, value = "1"),
		            @org.hibernate.annotations.Parameter(
		                name = StringSequenceIdentifier.VALUE_PREFIX_PARAMETER, value = "IG_"),
		            @org.hibernate.annotations.Parameter(
			                name = StringSequenceIdentifier.NUMBER_FORMAT_PARAMETER, value = "%03d")
		        }
		    )
		@GeneratedValue(generator="id_sequence",strategy = GenerationType.SEQUENCE)
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


