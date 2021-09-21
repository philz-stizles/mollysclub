package com.devdezyn.mollysclub.shared.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig implements EnvironmentAware {
    // @Autowired
    private Environment environment;
    
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devdezyn.mollysclub"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enable(Boolean.parseBoolean(environment.getProperty("app.swagger.on")));
    }

//    private Predicate<String> postPaths() {
//        return Predicates.or(
//                PathSelectors.regex("/api/v1/categories")
//        );
//    }
//
//    // Only select apis that matches the given Predicates.
//    private Predicate<String> paths() {
//        // Match all paths except /error
//        return Predicates.and(
//                PathSelectors.regex("/.*"),
//                Predicates.not(PathSelectors.regex("/error.*"))
//        );
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Mollys Club API")
                .description("A full Java Developer project with robust technology implementations")
                .termsOfServiceUrl("https://devdezyn.io/mollysclub/termsOfService")
                .contact(new Contact(
                        "Philz Stizles",
                        "https://devdezyn.com/mollysclub",
                        "philz.stizles@devdezyn.com"
                )).license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com")
                .version("1.0")
                .build();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}