package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc //webMVC 알아서 설정 세팅해줌 <-원래는 관리 객체를 다 설정해줘야 함
@ComponentScan("org.choongang") //자동 스캔, 수동 등록 빈은 특수한 상황을 제외하고는 잘 안만든다
@Import({DBConfig.class, MessageConfig.class, InterceptorConfig.class}) //DB, Msg, Interceptor 설정 클래스 가져와서 사용, 여러개일 경우 배열 형태로 작성, 편리한 관리 위해 설정 파일을 분리
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer { //webMVC 설정 인터페이스 구현(중요! 암기!)

    /*
    private final JoinValidator joinValidator;

    //모든 컨트롤러에 적용될 수 있는 전역 validator
    @Override
    public Validator getValidator() {
        return joinValidator;
    }
    //보통 특정 요소만 검증이 필요하고 굳이 전역 검증을 할 필요는 없기 때문에 거의 사용 안함
     */

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

    //간단한 페이지 연결
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/") //main path
                .setViewName("main/index");

        registry.addViewController("/mypage") // 패턴 입력 가능->/mypage/**: mypage를 포함한 모든 하위 패키지
                .setViewName("mypage/index");
    }

    //필수 메서드
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
