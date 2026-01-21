package com.example.plazoleta.aplication.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantRequest {
    @Schema(example = "Restaurante Gourmet", description = "Nombre del restaurante")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Schema(example = "123456789", description = "NIT numérico")
    @NotBlank(message = "El NIT es obligatorio")
    private String nit;
    @NotBlank(message = "La dirección es obligatoria")
    private String address;
    @NotBlank(message = "El teléfono es obligatorio")
    private String phone;
    @NotBlank(message = "La URL del logo es obligatoria")
    private String urlLogo;
    @NotNull(message = "El ID del propietario es obligatorio")
    private Long idOwner;
}
