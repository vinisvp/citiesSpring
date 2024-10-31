package com.fatec.cities_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CityRequest(
    @NotBlank(message = "Name can't be null")
    @Size(min = 1, message = "Name minimun size is 1 character")
    String name,

    @NotBlank(message = "State can't be null")
    @Size(min = 3, message = "Name minimun size is 3 characters")
    String state,
    
    @NotBlank(message = "Country can't be null")
    @Size(min = 3, message = "Country minimun size is 3 characters")
    String country,
    
    @NotBlank(message = "Mayor can't be null")
    @Size(min = 3, message = "Mayor minimun size is 3 characters")
    String mayor,

    @NotNull(message = "Population can't be null")
    Integer population,
    
    @NotNull(message = "Population can't be null")
    Double gdp
) {

}
