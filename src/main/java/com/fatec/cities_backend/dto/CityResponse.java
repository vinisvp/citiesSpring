package com.fatec.cities_backend.dto;

public record CityResponse(
    Long id,
    String name,
    String state,
    String country,
    String mayor,
    Integer population,
    Double gdp
) {
    
}
