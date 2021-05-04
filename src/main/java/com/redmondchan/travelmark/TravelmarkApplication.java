package com.redmondchan.travelmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.redmondchan.travelmark.controllers.CountryController;

@SpringBootApplication
@ComponentScan(basePackageClasses = CountryController.class)
public class TravelmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelmarkApplication.class, args);
	}

}
