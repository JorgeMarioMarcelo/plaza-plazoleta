package com.example.plazoleta.domain.spi;

public interface IUserValidationPort {
    boolean isOwnerRole(Long userId);
    boolean isUserAdmin(Long userId);
}
