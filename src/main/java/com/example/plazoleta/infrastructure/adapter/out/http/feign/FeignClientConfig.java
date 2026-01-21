package com.example.plazoleta.infrastructure.adapter.out.http.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 1. Obtenemos la petición que llegó a Plazoleta desde Postman
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

                if (attributes != null) {
                    HttpServletRequest request = attributes.getRequest();
                    // 2. Extraemos el encabezado "Authorization" (donde viene tu usuario/clave o token)
                    String authorizationHeader = request.getHeader("Authorization");

                    if (authorizationHeader != null) {
                        // 3. Se lo pasamos tal cual al micro de usuarios
                        template.header("Authorization", authorizationHeader);
                    }
                }
            }
        };
    }
}
