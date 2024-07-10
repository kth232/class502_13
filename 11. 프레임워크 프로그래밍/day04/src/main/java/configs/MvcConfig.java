package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //설정 클래스로 인식
@EnableWebMvc // 스프링 MVC 설정 활성화, 기본 세팅
@ComponentScan("member") //자동 스캔 범위를 member 패키지 하위 모든 패키지로 넓게 지정
@Import(DBConfig.class) //다른 설정 클래스 사용
public class MvcConfig implements WebMvcConfigurer { //WebMvcConfigurer impl 필수!
    //web 관련 기본 세팅!! 필수!!

    //특정 객체가 들어오면 그에 맞는 뷰를 선택하도록 경로 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp"); //(경로, 확장자)
        //prefix: 앞에 붙는 주소, suffix: 뒤에 붙는 주소
    }

    
    //기본 경로 처리 세팅-> 경로 "/"일 때
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
