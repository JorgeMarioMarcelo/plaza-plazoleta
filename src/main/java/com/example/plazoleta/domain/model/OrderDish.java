package com.example.plazoleta.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDish {
    private Long id;
    private Long idOrder;
    private Long idDish;
    private Integer quantity;
}