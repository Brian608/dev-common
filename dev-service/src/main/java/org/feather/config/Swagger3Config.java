package org.feather.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @projectName: dev-common
 * @package: org.feather.config
 * @className: Swagger3Config
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 11:39
 * @version: 1.0
 */
@Slf4j
@Configuration
public class Swagger3Config {
        @Value("${server.port:}")
        private String port;

     @Bean
    public Docket createRestApi() {
         log.info("接口地址:"+"http://localhost:"+port+"/swagger-ui/");
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("xxxxxxx")
                .contact(new Contact("feather", "http://xxx.com", "Brian608@163.com"))
                .version("1.0")
                .build();
    }
}
