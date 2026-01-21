package com.example.plazoleta.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedidos_platos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private OrderEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private DishEntity plato;

    @Column(nullable = false)
    private Integer cantidad;
}
