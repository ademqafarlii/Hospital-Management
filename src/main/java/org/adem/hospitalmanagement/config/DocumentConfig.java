package org.adem.hospitalmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class DocumentConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Hospital Management")
                        .description("A hospital management system is a software solution designed to streamline" +
                                " and automate the administrative, financial and clinical operations of a healthcare facility")
                        .contact(new Contact()
                                .email("ademqafarli88@gmail.com")
                                .url("www.linkedin.com/in/adem-qafarli-653913295")
                                .url("https://gitlab.com/ademqafarli77")
                                .url("https://github.com/ademqafarlii")
                                .name("Adem Qafarli"))
        );
    }
}
