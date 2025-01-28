package com.rising.raimon.emblem.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(@Value("v1") final String appVersion) {
        return new OpenAPI()
//                TODO -> Analizar si se añadirá securización
//                .components(new Components()
//                        .addSecuritySchemes("bearer-key", new SecurityScheme()
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")
//                        )
//                )
                .info(new Info()
                        .title("RisingRaimonEmblem API")
                        .version(appVersion)
                        .license(new License().name("API License").url("none"))
//                TODO -> Analizar si se añadirá securización
//                ).addSecurityItem(
//                        new SecurityRequirement()
//                                .addList("bearer-jwt", Arrays.asList("read", "write"))
//                                .addList("bearer-key", Collections.emptyList())
                );
    }
}
