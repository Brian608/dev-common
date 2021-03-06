package org.feather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: DevCommonApplication
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/3 08:45
 * @version: 1.0
 */
@EnableOpenApi
@SpringBootApplication
public class DevCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevCommonApplication.class,args);
    }
}
