package com.example.plazoleta.infrastructure.adapter.out.http.adapter;

import com.example.plazoleta.domain.spi.IUserValidationPort;
import com.example.plazoleta.infrastructure.adapter.out.http.dto.UserResponse;
import com.example.plazoleta.infrastructure.adapter.out.http.feign.IUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserValidationAdapter implements IUserValidationPort {

    private final IUserClient userClient;

    @Override
    public boolean isOwnerRole(Long userId) {
        UserResponse user = userClient.getUserById(userId);
        return user != null && "PROPIETARIO".equals(user.getRolName());
    }

    @Override
    public boolean isUserAdmin(Long userId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            // Imprime para estar 100% seguros de qué llega
            auth.getAuthorities().forEach(a -> System.out.println("Rol en Contexto: " + a.getAuthority()));

            return auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));
        }
        return false;
    }
}
