package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@EnableWebMvc //webMVC 알아서 설정 세팅해줌 <-원래는 관리 객체를 다 설정해줘야 함, 한군데에만 넣으면 필요한 모든 객체 만들어줌
@ComponentScan("org.choongang") //자동 스캔, 수동 등록 빈은 특수한 상황을 제외하고는 잘 안만든다
/*
@Import({DBConfig.class, //스캔 범위가 아니고 스스로 configuration을 생성하지 못할 때 추가
        MessageConfig.class,
        InterceptorConfig.class, //DB, Msg, Interceptor, file 설정 클래스 가져와서 사용,
        FileConfig.class}) //여러개일 경우 배열 형태로 작성, 편리한 관리 위해 설정 파일을 분리
 */
//@RequiredArgsConstructor
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
    /*
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
    */

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {//static으로 정의해야 함
        //PropertySources / PlaceholderConfigurer : 설정 내용 / 설정 방식

        String fileName = "application";
        String profile = System.getenv("spring.profiles.active");
        fileName += StringUtils.hasText(profile) ? "-" + profile : "";

        /**
         * spring.profiles.active=dev
         * -> application-dev
         *
         * spring.profiles.active=prod
         * -> application-prod
         */

        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(new ClassPathResource(fileName + ".properties")); //설정 파일들(복수개)을 매개변수로 넣어줌
        //resource 폴더 = classPath
        //"application.properties"

        return conf;
    }

    //따로 @JsonFormatter를 정의하지 않아도 공통적으로 JSON 날짜 형식화 해줌
    @Override //JSON 등 응답 메세지 출력 형식 변환을 위해 사용하는 메서드
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json() //응답 형식 설정->json으로 자동 변환 , xml로도 변환 가능(의존성 필요)
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                .build();

        //converter에 있는 설정은 우선순위 존재
        //여기서 정의한 설정의 우선순위를 가장 앞으로 설정
        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }
}