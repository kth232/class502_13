package org.choongang.global.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

//문서에 관한 설명 추가
@OpenAPIDefinition(info=@Info(title="API명세", description = "desc..", contact = @Contact(name="kth", email="kth7537@naver.com"), version="v1"))
@Configuration()
public class SwaggerConfig {

    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("API명세") //ex) 회원쪽이라면 회원명세
                .pathsToMatch("api/v1/**")
                .build();
    }
}
