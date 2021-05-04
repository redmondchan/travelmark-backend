package com.redmondchan.travelmark.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;





@Entity
@Table(name="countries")
@SequenceGenerator(name= "country_sequence", initialValue = 1, allocationSize = 1)
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " country_sequence")
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	} 
	
}
