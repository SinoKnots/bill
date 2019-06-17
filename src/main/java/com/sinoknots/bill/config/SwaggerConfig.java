/**
 * Created on 2018年3月23日 下午2:56:40
 */
package com.sinoknots.bill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类 . <br>
 * 访问路径: http://localhost:8080/springboot/swagger-ui.html
 * 
 * @author hkb <br>
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
    	String controllerPack = "com.sinoknots.bill.ui.ctrl";
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(controllerPack)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        String title = "Bill System RESTful API";
        String version = "1.0.0";
        String description = "Bill System 实行的是前后端分离的开发理念，使用Swagger来减少后端开发的接口文档编写工作";
        return new ApiInfoBuilder().title(title).description(description).version(version).build();
    }

}
