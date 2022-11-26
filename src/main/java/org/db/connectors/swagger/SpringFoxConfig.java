package org.db.connectors.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket mariaDBApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("mariaDb api's")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.db.connectors"))
                .paths((PathSelectors.ant("/mariaDB/**")))
                .build().apiInfo(getApiInfo());
    }

    @Bean
    public Docket redisApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("redis api's")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.db.connectors"))
                .paths((PathSelectors.ant("/redis/**")))
                .build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Invertory application",
                "Invertory application microservice",
                "1",
                "TERMS OF SERVICE URL",
                new Contact("Asen Nikolaev", "URL", "asen.nikolaev95@abv.bg"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
