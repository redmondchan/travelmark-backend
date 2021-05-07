package com.redmondchan.travelmark.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="articles")
@SequenceGenerator(name= "article_sequence", initialValue = 1, allocationSize = 1)
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " article_sequence")
	private int id;
	private String title;
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "fk_city_id", referencedColumnName = "id")
	private City city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}
