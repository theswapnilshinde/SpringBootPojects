package com.netprizm.ccss.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths1()).build();
	}

	private Predicate<String> postPaths1() {
		return or(regex("/central-cfg-service.*"),regex("/central-cfg-service-v2.*"));
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Central-cfg-Service Java  API ")
				.description("central-cfg-service for reserve and relase ")
				.termsOfServiceUrl("http:8081/api/")
			
				.licenseUrl("central-cfg-service").version(" 2.01netprizm.app 2.01").build();
	}
	
}
