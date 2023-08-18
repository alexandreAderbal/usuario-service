package br.com.usuario.service.configuracao;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import static br.com.usuario.service.constants.OpenApiConstants.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
            .components(getComponents())
            .info(new Info().title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION));
    }

    private Components getComponents () {
        return new Components().addSecuritySchemes(
            BEARER_AUTH,
            new SecurityScheme()
                .scheme(BEARER)
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat(JWT)
                .name(API)
                .in(SecurityScheme.In.HEADER)
        );
    }
}