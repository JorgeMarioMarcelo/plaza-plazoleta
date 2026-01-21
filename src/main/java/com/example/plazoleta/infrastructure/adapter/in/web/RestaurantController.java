package com.example.plazoleta.infrastructure.adapter.in.web;

import com.example.plazoleta.aplication.dto.request.RestaurantRequest;
import com.example.plazoleta.aplication.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurantes")
@RequiredArgsConstructor
public class RestaurantController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Crear un nuevo restaurante",
            description = "Solo accesible por usuarios con rol ADMINISTRADOR")
    @PostMapping
    public ResponseEntity<Void> createRestaurant(@Valid @RequestBody RestaurantRequest restaurantRequest) {
        restaurantHandler.saveRestaurantInService(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
