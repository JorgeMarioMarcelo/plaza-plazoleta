package com.example.plazoleta.domain.usecase;

import com.example.plazoleta.domain.api.IRestaurantServicePort;
import com.example.plazoleta.infrastructure.exception.BusinessException;
import com.example.plazoleta.infrastructure.exception.UserNotAllowedException;
import com.example.plazoleta.domain.model.Restaurant;
import com.example.plazoleta.domain.spi.IRestaurantPersistencePort;
import com.example.plazoleta.domain.spi.IUserValidationPort;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserValidationPort userValidationPort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserValidationPort userValidationPort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userValidationPort = userValidationPort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if (restaurant.getName().matches("^\\d+$")) {
            throw new BusinessException("El nombre del restaurante no puede ser solo números.");
        }

        if (!restaurant.getNit().matches("^\\d+$")) {
            throw new BusinessException("El NIT debe ser puramente numérico.");
        }

        if (!restaurant.getPhone().matches("^\\+?\\d{1,12}$")) {
            throw new BusinessException("Formato de teléfono inválido. Máximo 13 caracteres y solo números.");
        }

        if (!userValidationPort.isOwnerRole(restaurant.getIdOwner())) {
            throw new BusinessException("El ID de usuario proporcionado no corresponde a un Propietario.");
        }

        if (!userValidationPort.isUserAdmin(restaurant.getIdOwner())) {
            throw new UserNotAllowedException("Solo un administrador puede registrar un restaurante");
        }

        restaurantPersistencePort.saveRestaurant(restaurant);
    }
}
