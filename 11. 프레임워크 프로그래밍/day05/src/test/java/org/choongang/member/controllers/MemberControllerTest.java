package org.choongang.member.controllers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//servlet 패키지로 import

//웹을 켜놓고 수정하면서 테스트할 때마다 stop and rerun 하기 번거로움->MockMvc로 서버 켜지 않고 테스트 가능
@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class) //설정 클래스
public class MemberControllerTest { //테스트의 목적? 내가 원하는 결과가 나오는지 확인하는 것

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        //특정 컨트롤러만 테스트하거나 컨테이너를 대상으로 테스트할 수도 있음(의존성 추가된 상태)
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); //다형성 적용하기 위함, WebApplicationContext 인터페이스
    }

    @Test
    void test01() throws Exception {
        mockMvc.perform(post("/member/join")
                        .header("appKey", "1234") //요청 헤더에 키값
                        .contentType(MediaType.APPLICATION_JSON_VALUE) //contentType 한정/ "application/json"
                ) 
                .andDo(print()); //resultHandler: 결과 처리
        // andDo(print()): 요청에 대한 자세한 정보 출력, 오류 탐색에 활용
    }

    @Test
    void test02() throws Exception{
        mockMvc.perform(get("/member/join") //get 방식
                .header("Accept-Language", Locale.KOREAN.getLanguage())
                        //Accept-Language: 요청 헤더에 실려오는 언어 정보, 순위 높은 순으로 나열
                )
                .andDo(print());
    }
}