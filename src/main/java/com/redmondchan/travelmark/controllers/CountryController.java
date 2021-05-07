package com.redmondchan.travelmark.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	 public ResponseEntity<Object> getCountry(@PathVariable("id") int id) {
		 
		 //return" inside getUser method";
		 return new ResponseEntity<>(countryRepository.findById(id), HttpStatus.OK);
	 }
	 
	 @PostMapping("/country")
	 ResponseEntity<Country> createCountry(@RequestBody Country country) throws URISyntaxException {
		 System.out.println(country.toString());
		 Country result = countryRepository.save(country);
		 System.out.println(country.toString());
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
	 
	 //endpoint to utilize an api to populate the database with countries and cities
	 @GetMapping("/createDb")
	 public ResponseEntity<Object> createDb() {
			try {
				
				URL url = new URL("https://countriesnow.space/api/v0.1/countries");
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				
				//Get response code
				int responseCode = conn.getResponseCode();
				
				if(responseCode != 200) {
					throw new RuntimeException("HttpResponseCode:" + responseCode);
				} else {
					String inLine = "";
					Scanner scanner = new Scanner(url.openStream());
					
					//write all json data into a string 
					while(scanner.hasNext()) {
						inLine += scanner.nextLine();
					}
					
					scanner.close();
					
					JSONParser parse = new JSONParser();
					JSONObject dataObj = (JSONObject) parse.parse(inLine);
					
					//JSONObject obj = (JSONObject) dataObj;
					//System.out.println(obj.get("msg"));
					
					JSONArray countryArr = (JSONArray) dataObj.get("data");
					for(int i = 0; i < countryArr.size(); i++) {
						JSONObject newObject = (JSONObject) countryArr.get(i);
						//System.out.println(newObject.get("country"));
						String countryName = (String) newObject.get("country");
						//System.out.println(countryName);
						Country country = new Country();
						country.setName(countryName);
						System.out.println(country.toString());
						Country savedCountry = countryRepository.save(country);
	 				}
					
				}
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("in catch");
				e.printStackTrace();
			}
		 return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
	 }
}
