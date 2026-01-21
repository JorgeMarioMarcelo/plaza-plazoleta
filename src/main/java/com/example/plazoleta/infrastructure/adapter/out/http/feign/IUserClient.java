package com.example.plazoleta.infrastructure.adapter.out.http.feign;

import com.example.plazoleta.infrastructure.adapter.out.http.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "localhost:8080/api/v1/usuarios",configuration = FeignClientConfig.class)
public interface IUserClient {
    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
