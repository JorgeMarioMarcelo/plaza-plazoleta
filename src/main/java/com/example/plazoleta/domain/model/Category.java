package com.example.plazoleta.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String description;
}