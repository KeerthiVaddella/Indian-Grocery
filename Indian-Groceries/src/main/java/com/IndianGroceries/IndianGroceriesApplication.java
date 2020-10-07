package com.IndianGroceries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class IndianGroceriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndianGroceriesApplication.class, args);
	}

}
