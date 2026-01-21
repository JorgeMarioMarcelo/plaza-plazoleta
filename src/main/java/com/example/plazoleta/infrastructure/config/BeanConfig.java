package com.example.plazoleta.infrastructure.config;

import com.example.plazoleta.domain.api.IRestaurantServicePort;
import com.example.plazoleta.domain.usecase.RestaurantUseCase;
import com.example.plazoleta.infrastructure.adapter.out.http.adapter.UserValidationAdapter;
import com.example.plazoleta.infrastructure.adapter.RestaurantPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final RestaurantPersistenceAdapter restaurantPersistenceAdapter;
    private final UserValidationAdapter userValidationAdapter;

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistenceAdapter, userValidationAdapter);
    }
}
