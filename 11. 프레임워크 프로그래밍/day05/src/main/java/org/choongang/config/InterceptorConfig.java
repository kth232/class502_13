package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.choongang.global.interceptors.MemberOnlyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    //WebMvcConfigurer 필요한 만큼 정의 가능->단, 같은 메서드를 각각 오버라이딩하면 안됨
    //설정 별로 분리해서 관리하는 것이 좋다

    private final MemberOnlyInterceptor memberOnlyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor)
                .addPathPatterns("/mypage/**"); //Ant 패턴
        //마이 페이지를 포함한 모든 경로 등록
    }
}
