package com.redmondchan.travelmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redmondchan.travelmark.models.Country;

@Repository("CountryRepository")
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
