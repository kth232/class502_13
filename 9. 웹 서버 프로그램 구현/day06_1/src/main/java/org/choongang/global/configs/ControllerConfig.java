package org.choongang.global.configs;

import org.choongang.member.controllers.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    //수동 등록 빈보다 컴포넌트 스캔으로 자동 등록
//    @Bean
//    public MemberController memberController() {
//        return new MemberController();
//    }
}
