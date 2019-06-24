package br.com.ufpe.course.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket = Docket(SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(API_INFO)
        .produces(DEFAULT_PRODUCES_CONSUMES)
        .consumes(DEFAULT_PRODUCES_CONSUMES)
        .host("http://localhost:8080/")

    private companion object {
        val DEFAULT_CONTACT = Contact("José Eudes", "zeeudes@icloud.com", "zeeudes@icloud.com")
        val DEFAULT_PRODUCES_CONSUMES = hashSetOf(APPLICATION_JSON.toString())
        val API_INFO = ApiInfo(
            "Awesome API Title",
            "Awesome API Documentation",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache2.0",
            "http://www.apache.org/licenses/LICENCE-2.0",
            listOf()
        )
    }
}