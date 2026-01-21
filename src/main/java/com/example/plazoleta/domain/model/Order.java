package com.example.plazoleta.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long idClient;
    private LocalDateTime date;
    private String status;
    private Long idChef;
    private Long idRestaurant;
}