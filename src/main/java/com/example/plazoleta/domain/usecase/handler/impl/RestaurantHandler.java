package com.example.plazoleta.domain.usecase.handler.impl;

import com.example.plazoleta.domain.usecase.dto.request.RestaurantRequest;
import com.example.plazoleta.domain.usecase.handler.IRestaurantHandler;
import com.example.plazoleta.domain.usecase.mapper.IRestaurantRequestMapper;
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
