package com.fatec.cities_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.cities_backend.dto.CityRequest;
import com.fatec.cities_backend.dto.CityResponse;
import com.fatec.cities_backend.mappers.CityMapper;
import com.fatec.cities_backend.models.City;
import com.fatec.cities_backend.repositories.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<CityResponse> getAll(){
        return cityRepository.findAll()
                             .stream()
                             .map(c -> CityMapper.toDto(c))
                             .toList();
    }

    public CityResponse getById(long id){
        City city = cityRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("City not found!"));
        return CityMapper.toDto(city);
    }

    public CityResponse post(CityRequest request) {
        City city = cityRepository.save(CityMapper.toEntity(request));
        return CityMapper.toDto(city);
    }

    public void delete(long id){
        if(cityRepository.existsById(id)){
            cityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("City not found!");
        }
    }

    public void put(long id, CityRequest request){
        City city = cityRepository.getReferenceById(id);
        
        city.setName(request.name());
        city.setState(request.state());
        city.setCountry(request.country());
        city.setMayor(request.mayor());
        city.setPopulation(request.population());
        city.setGdp(request.gdp());

        cityRepository.save(city);
    }
}
