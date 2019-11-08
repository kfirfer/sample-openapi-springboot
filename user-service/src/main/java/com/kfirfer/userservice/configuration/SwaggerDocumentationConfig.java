package com.kfirfer.userservice.configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Spring Boot 2 Actuator Swagger API")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo() {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        builder
                .title("Kfir Spring Boot API")
                .version("1.0")
                .license("Apache License Version 2.0")
                .description("List of all endpoints used in API")
                .contact(new Contact("Kfir Fersht", "https://kfirfer.com/about/", "kfirfer@gmail.com"))
                .termsOfServiceUrl("https://www.apache.org/licenses/LICENSE-2.0");
        return builder.build();
    }

    private Predicate<String> paths() {
        // Match all paths except /error
        return Predicates.and(
                PathSelectors.any(),
                Predicates.not(PathSelectors.regex("/error.*|/admin.*"))
        );
    }
}
