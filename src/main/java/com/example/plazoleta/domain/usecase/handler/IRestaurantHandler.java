package com.example.plazoleta.domain.usecase.handler;

import com.example.plazoleta.domain.usecase.dto.request.RestaurantRequest;

public interface IRestaurantHandler {
    void saveRestaurantInService(RestaurantRequest restaurantRequest);
}