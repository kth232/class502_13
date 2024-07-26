package org.choongang.global.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing // 변화 감지 감독 관련 설정 자동화
@EnableScheduling //스케줄링 설정 활성화, 필요할 때만 사용하기 때문에 직접 설정해야 함
@Configuration
public class MvcConfig implements WebMvcConfigurer { //WebMvcConfigurer 설정 꼭 기억하기!
}
