package com.example.plazoleta.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurantes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private String direccion;

    @Column(length = 13)
    private String telefono;

    @Column(name = "url_logo", nullable = false)
    private String urlLogo;

    @Column(name = "id_propietario", nullable = false)
    private Long idPropietario;
}
