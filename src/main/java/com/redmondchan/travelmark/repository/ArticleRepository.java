package com.redmondchan.travelmark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redmondchan.travelmark.models.Article;
import com.redmondchan.travelmark.models.City;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query("SELECT article FROM Article article WHERE article.city.country.id = ?1")
	public List<Article> findArticlesByCountry(int countryId);
	
	@Query("SELECT article FROM Article article WHERE article.city.id = ?1")
	public List<Article> findArticlesByCity(int cityId);
	
}
