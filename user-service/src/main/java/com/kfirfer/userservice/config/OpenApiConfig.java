package com.kfirfer.userservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi userOpenApi() {
        String[] paths = {"/user/**"};
        String[] packagedToMatch = {"com.kfirfer.userservice.controller"};
        return GroupedOpenApi.builder().setGroup("users").pathsToMatch(paths).packagesToScan(packagedToMatch)
                .build();
    }

    @Bean
    public GroupedOpenApi storeOpenApi() {
        String[] paths = {"/store/**"};
        return GroupedOpenApi.builder().setGroup("stores").pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi petOpenApi() {
        String[] paths = {"/pet/**"};
        return GroupedOpenApi.builder().setGroup("pets").pathsToMatch(paths)
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI().openapi("3.0.2")
                .components(new Components().addSecuritySchemes("api_key",
                        new SecurityScheme().type(SecurityScheme.Type.APIKEY).name("api_key").in(SecurityScheme.In.HEADER))
                        .addSecuritySchemes("petstore_auth", new SecurityScheme().type(SecurityScheme.Type.OAUTH2).flows(new OAuthFlows()
                                .implicit(new OAuthFlow().authorizationUrl("https://petstore3.swagger.io/oauth/authorize")
                                        .scopes(new Scopes().addString("write:pets", "modify pets in your account").addString("read:pets", "read your pets"))))))
                .info(new Info().title("Swagger Petstore - OpenAPI 3.0").version(appVersion).description(
                        "This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
