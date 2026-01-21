package com.example.plazoleta.domain.usecase;

import com.example.plazoleta.domain.model.Restaurant;
import com.example.plazoleta.domain.spi.IRestaurantPersistencePort;
import com.example.plazoleta.domain.spi.IUserValidationPort;
import com.example.plazoleta.infrastructure.exception.BusinessException;
import com.example.plazoleta.infrastructure.exception.UserNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantUseCaseTest {

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @Mock
    private IUserValidationPort userValidationPort;

    @InjectMocks
    private RestaurantUseCase restaurantUseCase;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant();
        restaurant.setName("Restaurante Test");
        restaurant.setNit("123456");
        restaurant.setAddress("Calle 1");
        restaurant.setPhone("+573001234567");
        restaurant.setUrlLogo("http://logo.com");
        restaurant.setIdOwner(1L);
    }

    @Test
    @DisplayName("Debe guardar restaurante cuando todas las validaciones pasan")
    void saveRestaurant_Success() {
        // Arrange
        when(userValidationPort.isOwnerRole(1L)).thenReturn(true);
        when(userValidationPort.isUserAdmin(anyLong())).thenReturn(true);

        // Act
        restaurantUseCase.saveRestaurant(restaurant);

        // Assert
        verify(restaurantPersistencePort, times(1)).saveRestaurant(restaurant);
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el nombre es solo números")
    void saveRestaurant_InvalidName_ThrowsException() {
        restaurant.setName("123456");

        BusinessException exception = assertThrows(BusinessException.class, () ->
                restaurantUseCase.saveRestaurant(restaurant)
        );

        assertEquals("El nombre del restaurante no puede ser solo números.", exception.getMessage());
        verify(restaurantPersistencePort, never()).saveRestaurant(any());
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el NIT no es numérico")
    void saveRestaurant_InvalidNit_ThrowsException() {
        restaurant.setNit("123-ABC");

        BusinessException exception = assertThrows(BusinessException.class, () ->
                restaurantUseCase.saveRestaurant(restaurant)
        );

        assertEquals("El NIT debe ser puramente numérico.", exception.getMessage());
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el formato del teléfono es inválido")
    void saveRestaurant_InvalidPhone_ThrowsException() {
        restaurant.setPhone("abc12345");

        BusinessException exception = assertThrows(BusinessException.class, () ->
                restaurantUseCase.saveRestaurant(restaurant)
        );

        assertTrue(exception.getMessage().contains("Formato de teléfono inválido"));
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el usuario no es PROPIETARIO")
    void saveRestaurant_NotOwner_ThrowsException() {
        when(userValidationPort.isOwnerRole(1L)).thenReturn(false);

        BusinessException exception = assertThrows(BusinessException.class, () ->
                restaurantUseCase.saveRestaurant(restaurant)
        );

        assertEquals("El ID de usuario proporcionado no corresponde a un Propietario.", exception.getMessage());
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el que opera no es ADMINISTRADOR")
    void saveRestaurant_NotAdmin_ThrowsException() {
        when(userValidationPort.isOwnerRole(1L)).thenReturn(true);
        when(userValidationPort.isUserAdmin(anyLong())).thenReturn(false);

        UserNotAllowedException exception = assertThrows(UserNotAllowedException.class, () ->
                restaurantUseCase.saveRestaurant(restaurant)
        );

        assertEquals("Solo un administrador puede registrar un restaurante", exception.getMessage());
    }
}