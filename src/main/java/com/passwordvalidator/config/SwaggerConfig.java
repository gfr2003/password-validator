package com.passwordvalidator.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI passwordValidatorOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Password Validator API")
                        .description("API for validating passwords against security rules.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Gustavo Félix Rodrigues Kojima")
                                .email("gustavo.felixr@outlook.com")));
    }
}
