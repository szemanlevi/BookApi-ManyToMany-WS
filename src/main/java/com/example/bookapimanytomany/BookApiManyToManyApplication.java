package com.example.bookapimanytomany;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Table4 API",
                version = "1.0.1",
                description = "Swagger is cool"
        )
)
public class BookApiManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApiManyToManyApplication.class, args);
    }

}
