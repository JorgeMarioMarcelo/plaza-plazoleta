package com.example.plazoleta.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserNotAllowedException.class)
    public ResponseEntity<Map<String, String>> handleUserNotAllowedException(UserNotAllowedException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Collections.singletonMap("error", exception.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(BusinessException businessException) {
        // Aquí personalizamos la respuesta para que solo devuelva el mensaje
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", businessException.getMessage()));
    }

    @ExceptionHandler(feign.FeignException.NotFound.class)
    public ResponseEntity<Map<String, String>> handleFeignNotFoundException(feign.FeignException.NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "El ID del propietario no existe en el sistema de usuarios."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = new HashMap<>();

        // Obtenemos el defaultMessage del primer error encontrado
        String message = ex.getBindingResult().getAllErrors().getFirst().getDefaultMessage();

        errorResponse.put("message", message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
