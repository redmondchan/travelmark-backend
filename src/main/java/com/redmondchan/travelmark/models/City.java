package com.redmondchan.travelmark.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cities")
@SequenceGenerator(name= "city_sequence", initialValue = 1, allocationSize = 1)
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " city_sequence")

	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "fk_country_id", referencedColumnName = "id")
	private Country country;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
