package com.example.plazoleta.aplication.handler.impl;

import com.example.plazoleta.aplication.dto.request.RestaurantRequest;
import com.example.plazoleta.aplication.handler.IRestaurantHandler;
import com.example.plazoleta.aplication.mapper.IRestaurantRequestMapper;
import com.example.plazoleta.domain.api.IRestaurantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;

    @Override
    public void saveRestaurantInService(RestaurantRequest restaurantRequest) {
        restaurantServicePort.saveRestaurant(restaurantRequestMapper.toRestaurant(restaurantRequest));
    }
}
