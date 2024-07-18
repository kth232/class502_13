package org.choongang.config;

import lombok.RequiredArgsConstructor;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@RequiredArgsConstructor
public class ThymeleafConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver templateResolver() {//템플릿 경로 설정
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates2/");
        templateResolver.setSuffix(".html"); //natural 템플릿 지향
        //보통 디자이너가 주는 것은 html, 관례적으로 html 확장자 사용, 주는 대로 보여주기 위함
        //확장자는 사실 아무거나 해도 상관없음, 단, 다른 확장자라면 다 바꿔줘야 함
        templateResolver.setCacheable(false); //캐시 설정, 한번 번역되면 임시 저장해놓고 사용<-값이 잘 바뀌지 않음
        //개발 중엔 캐시를 true로 설정해놓으면 서버를 껐다가 다시 켜야 수정 부분 반영됨->false로 설정하고 작업
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); //EL식 지원
        templateEngine.addDialect(new Java8TimeDialect()); //확장 기능 설정
        templateEngine.addDialect(new LayoutDialect()); //
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8"); //한글 인코딩 기본 세팅
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver()); //설정 추가
    }
}
