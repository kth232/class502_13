package org.choongang.member.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.config.MvcConfig;
import org.choongang.member.controllers.RequestJoin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class ApiMemberControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
    private ApiMemberController controller;

//    @Autowired
//    private WebApplicationContext ctx;
    
    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); //특정 컨트롤러만 테스트
        //mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); //전체 설정을 가져오면 로딩 시간이 오래 걸림
    }
    
    @Test
    void test1() throws Exception {
        //content-type: application/json

        ObjectMapper om = new ObjectMapper(); //JSON을 자바 객체로, 자바 객체를 JSON으로 변환
        //Date & Time은 지원 안되기 때문에 별도로 설정 필요
        om.registerModule(new JavaTimeModule());

        RequestJoin form = new RequestJoin();
        form.setEmail("user100@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword("12345678");
        form.setUserName("user99");
        form.setAgree(true);

        String json = om.writeValueAsString(form);
        mockMvc.perform(post("/api/member")
                        .contentType(MediaType.APPLICATION_JSON) //요청 헤더, mediaType을 사용하면 오타 방지에 좋다
                        .content(json) //request body
                ).andDo(print())
                .andExpect(status().isCreated()); //예상값

        /*
        //content-type: application/x-www-form-urlencoded <-기본 형식
        //이름=값&이름=값...

        mockMvc.perform(post("/api/member")
                .param("email", "user99@test.org")
                .param("password", "12345678")
                .param("confirmPassword", "12345678")
                .param("userName", "user99")
                ).andDo(print()); //응답 내용 상세 확인 가능
         */
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/api/member/list"))
                .andDo(print());
    }
}
