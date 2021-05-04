package com.redmondchan.travelmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redmondchan.travelmark.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
