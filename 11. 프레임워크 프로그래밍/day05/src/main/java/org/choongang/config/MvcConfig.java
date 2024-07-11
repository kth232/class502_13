package org.choongang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc //webMVC 알아서 설정 세팅해줌 <-원래는 관리 객체를 다 설정해줘야 함
@ComponentScan("org.choongang") //자동 스캔, 수동 등록 빈은 특수한 상황을 제외하고는 잘 안만든다
@Import(DBConfig.class) //DB 설정 클래스 가져와서 사용
public class MvcConfig implements WebMvcConfigurer { //webMVC 설정 인터페이스 구현

    //필수 메서드
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //정적 경로 설정하는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //"/**": 모든 경로
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    //필수 메서드
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
