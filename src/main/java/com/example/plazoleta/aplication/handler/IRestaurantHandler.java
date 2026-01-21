package com.example.plazoleta.aplication.handler;

import com.example.plazoleta.aplication.dto.request.RestaurantRequest;

public interface IRestaurantHandler {
    void saveRestaurantInService(RestaurantRequest restaurantRequest);
}