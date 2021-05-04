package com.redmondchan.travelmark.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redmondchan.travelmark.models.Country;
import com.redmondchan.travelmark.repository.CountryRepository;

@RestController

public class CountryController {
	 @Autowired
	 private CountryRepository countryRepository;
	 
	 @GetMapping("/country/{id}")
	 public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
		 
		 //return" inside getUser method";
		 return new ResponseEntity<>(countryRepository.findById(id), HttpStatus.OK);
	 }
	 
	 @PostMapping("/country")
	 ResponseEntity<Country> createCountry(@RequestBody Country country) throws URISyntaxException {
		 Country result = countryRepository.save(country);
		 System.out.println("test");
		 return ResponseEntity.created(new URI("/country" + result.getId())).body(result);
	 }
	 
	 @GetMapping("/countries")
	 public ResponseEntity<Object> getCountries() {
		 return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/deleteAllCountries")
	 public ResponseEntity<Object> deleteAll() {
		 countryRepository.deleteAll();
		 return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
	 }
}
