package com.fatec.cities_backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.cities_backend.dto.CityResponse;
import com.fatec.cities_backend.services.CityService;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService cityService;
    
    @GetMapping
    public ResponseEntity<List<CityResponse>> getCities(){
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCity(@PathVariable long id){
        return ResponseEntity.ok(cityService.getById(id));
    }
}
