package com.example.plazoleta.infrastructure.adapter;

import com.example.plazoleta.domain.model.Restaurant;
import com.example.plazoleta.domain.spi.IRestaurantPersistencePort;
import com.example.plazoleta.infrastructure.adapter.out.persistence.mapper.IRestaurantEntityMapper;
import com.example.plazoleta.infrastructure.adapter.out.persistence.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RestaurantPersistenceAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }
}
