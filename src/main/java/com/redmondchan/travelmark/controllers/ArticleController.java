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

import com.redmondchan.travelmark.models.Article;
import com.redmondchan.travelmark.models.City;
import com.redmondchan.travelmark.repository.ArticleRepository;
import com.redmondchan.travelmark.repository.CityRepository;

@RestController
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CityRepository cityRepository;
	
	 @GetMapping("/article/{id}")
	 public ResponseEntity<Object> getArticles(@PathVariable("id") int id) {
		 
		 return new ResponseEntity<>(articleRepository.findById(id), HttpStatus.OK);
	 }
	 
	 @CrossOrigin
	 @PostMapping("/article")
	 ResponseEntity<Article> createArticles(@RequestBody Article article) throws URISyntaxException {
		 Article result = articleRepository.save(article);
		 System.out.println("test");
		 return ResponseEntity.created(new URI("/article/" + result.getId())).body(articleRepository.getOne(result.getId()));
	 }
	 
	 @GetMapping("/articles")
	 public ResponseEntity<Object> getArticles() {
		 return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/deleteAllArticle")
	 public ResponseEntity<Object> deleteAll() {
		 articleRepository.deleteAll();
		 return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/articlesByCountry/{id}")
	 public ResponseEntity<Object> getArticlesByCountry(@PathVariable("id") int id) {
		 
		 return new ResponseEntity<>(articleRepository.findArticlesByCountry(id), HttpStatus.OK);
	 }
}
