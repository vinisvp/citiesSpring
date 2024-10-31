package com.fatec.cities_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.cities_backend.models.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
