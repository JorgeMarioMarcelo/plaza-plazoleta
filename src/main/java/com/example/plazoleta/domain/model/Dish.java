package com.example.plazoleta.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String urlImage;
    private Boolean active;
    private Long idRestaurant;
    private Long idCategory;
}