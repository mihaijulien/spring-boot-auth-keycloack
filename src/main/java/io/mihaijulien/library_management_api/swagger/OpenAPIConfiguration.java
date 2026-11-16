package io.mihaijulien.library_management_api.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("dev");

        Info information = new Info()
                .title("Book Library Management API")
                .version("1.0")
                .description("API for books.");

        return new OpenAPI().info(information).servers(List.of(server));
    }
}

