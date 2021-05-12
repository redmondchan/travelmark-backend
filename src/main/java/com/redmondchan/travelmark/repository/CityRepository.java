package com.redmondchan.travelmark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redmondchan.travelmark.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query("SELECT city FROM City city WHERE city.country.id = ?1")
	public List<City> findCitiesByCountryId(int countryId);
}
