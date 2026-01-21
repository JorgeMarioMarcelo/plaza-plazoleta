package com.example.plazoleta.infrastructure.adapter.out.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class UserResponse {
    private Long id;
    @JsonProperty("rol")
    private String rolName;
}
