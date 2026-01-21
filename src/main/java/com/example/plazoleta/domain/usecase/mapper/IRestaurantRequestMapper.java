package com.example.plazoleta.domain.usecase.mapper;

import com.example.plazoleta.domain.usecase.dto.request.RestaurantRequest;
import com.example.plazoleta.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    // Convertimos de Request (DTO) a Restaurant (Modelo de dominio)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nit", source = "nit")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "urlLogo", source = "urlLogo")
    @Mapping(target = "idOwner", source = "idOwner")
    Restaurant toRestaurant(RestaurantRequest restaurantRequest);
}