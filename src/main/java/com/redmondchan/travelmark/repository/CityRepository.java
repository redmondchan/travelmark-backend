package com.redmondchan.travelmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redmondchan.travelmark.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
