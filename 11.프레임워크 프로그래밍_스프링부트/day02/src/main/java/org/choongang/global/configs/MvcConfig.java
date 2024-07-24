package org.choongang.global.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing // 변화 감지 감독 관련 설정 자동화
@Configuration
public class MvcConfig implements WebMvcConfigurer { //WebMvcConfigurer 설정 꼭 기억하기!
}
