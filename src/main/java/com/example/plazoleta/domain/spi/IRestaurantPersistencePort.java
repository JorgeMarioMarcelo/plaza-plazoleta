package com.example.plazoleta.domain.spi;

import com.example.plazoleta.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
}