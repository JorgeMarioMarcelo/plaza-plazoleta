package com.example.plazoleta.infrastructure.adapter.out.persistence.mapper;

import com.example.plazoleta.domain.model.Restaurant;
import com.example.plazoleta.infrastructure.adapter.out.persistence.entity.RestaurantEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRestaurantEntityMapper {
    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "nit", source = "nit")
    @Mapping(target = "direccion", source = "address")
    @Mapping(target = "telefono", source = "phone")
    @Mapping(target = "urlLogo", source = "urlLogo")
    @Mapping(target = "idPropietario", source = "idOwner")
    RestaurantEntity toEntity(Restaurant restaurant);

    @InheritInverseConfiguration
    Restaurant toModel(RestaurantEntity restaurantEntity);
}
