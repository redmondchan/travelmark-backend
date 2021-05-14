package com.redmondchan.travelmark.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redmondchan.travelmark.models.City;
import com.redmondchan.travelmark.repository.CityRepository;

@RestController
public class CityController {
	@Autowired
	private CityRepository cityRepository;
	
	 @GetMapping("/city/{id}")
	 public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
		 return new ResponseEntity<>(cityRepository.findById(id), HttpStatus.OK);
	 }
	 
	 @PostMapping("/city")
	 ResponseEntity<City> createCity(@RequestBody City city) throws URISyntaxException {
		 City result = cityRepository.save(city);
		 System.out.println("test");
		 return ResponseEntity.created(new URI("/city" + result.getId())).body(result);
	 }
	 
	 @GetMapping("/cities")
	 public ResponseEntity<Object> getCities() {
		 return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/deleteAllCities")
	 public ResponseEntity<Object> deleteAll() {
		 cityRepository.deleteAll();
		 return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @GetMapping("/findCitiesByCountryId/{id}")
	 public ResponseEntity<Object> findCitiesByCountryId(@PathVariable("id") int id) {
		 cityRepository.findCitiesByCountryId(id);
		 return new ResponseEntity<>(cityRepository.findCitiesByCountryId(id), HttpStatus.OK);
	 }
}
