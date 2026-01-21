package com.example.plazoleta.infrastructure.adapter.out.persistence.repository;

import com.example.plazoleta.infrastructure.adapter.out.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
