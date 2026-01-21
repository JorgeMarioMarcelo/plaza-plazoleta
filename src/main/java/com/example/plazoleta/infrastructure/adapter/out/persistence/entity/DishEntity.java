package com.example.plazoleta.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "platos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "url_imagen", nullable = false)
    private String urlImagen;

    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestaurantEntity restaurante;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoryEntity categoria;
}
