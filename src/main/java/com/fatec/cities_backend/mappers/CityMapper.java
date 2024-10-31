package com.fatec.cities_backend.mappers;

import com.fatec.cities_backend.dto.CityRequest;
import com.fatec.cities_backend.dto.CityResponse;
import com.fatec.cities_backend.models.City;

public class CityMapper {
    public static City toEntity(CityRequest request){
        City city = new City();
        city.setName(request.name());
        city.setState(request.state());
        city.setCountry(request.country());
        city.setMayor(request.mayor());
        city.setPopulation(request.population());
        city.setGdpPerCapita(request.gdpPerCapita());

        return city;
    }

    public static CityResponse toDto(City city){
        return new CityResponse(city.getId(), city.getName(), city.getState(), city.getCountry(), city.getMayor(), city.getPopulation(), city.getGdpPerCapita());
    }
}
