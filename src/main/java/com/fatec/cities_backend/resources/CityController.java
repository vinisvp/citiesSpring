package com.fatec.cities_backend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.cities_backend.dto.CityRequest;
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

    @PostMapping
    public ResponseEntity<CityResponse> postCity(@RequestBody CityRequest city){
        CityResponse newCity = cityService.post(city);

        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(newCity.id())
                       .toUri();
        
        return ResponseEntity.created(location).body(newCity);
    }
}
