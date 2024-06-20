package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Login Func Test")
public class LoginServiceTest {

    private LoginService loginService;
    private Faker faker;
    private RequestJoin form;
    private SqlSession dbSession; //DB 관련 세션
    
    @Mock
    private HttpServletRequest request; //모의 객체

    @Mock
    private HttpSession session;

    @BeforeEach
    void init() {
        loginService = MemberServiceProvider.getInstance().loginService();
        JoinService joinService = MemberServiceProvider.getInstance().joinService();

        faker = new Faker(Locale.ENGLISH); //영어 가짜 데이터 생성
        dbSession = MemberServiceProvider.getInstance().getSession(); //환경변수에 따라 세션 달라짐

        //회원가입->가입한 회원 정보로 email, password 스텁 생성
        form = RequestJoin.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase()) //reqexify에 공백 있으면 안됨
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();

        form.setConfirmPassword(form.getPassword());
        joinService.process(form);

        setData();

        given(request.getSession()).willReturn(session);
    }
    
    void setData() { //데이터 초기화를 위해 분리
        setParam("email", form.getEmail()); //회원가입한 메일
        setParam("password", form.getPassword()); //회원가입한 비번
    }
    
    //가짜 데이터 생성하는 메서드
    void setParam(String name, String value){
        given(request.getParameter(name)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 성공 시 예외 발생 없음")
    void successTest() {
        assertDoesNotThrow(()->{
           //LoginService loginService = new LoginService(); //@BeforeEach를 통해 테스트 수행 시마다 생성됨
           loginService.process(request);
        }); //통과가 무조건 되는 것부터 점점 확장해서 테스트 진행

        //로그인 처리 완료 시 HttpSession - setAttribute 메서드 호출 여부만 체크
        then(session).should(only()).setAttribute(any(), any()); 
    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {
        assertAll(
                ()->requiredEachFieldTest("email", false, "이메일"),
                ()->requiredEachFieldTest("email", true, "이메일"),
                ()->requiredEachFieldTest("password", false, "비밀번호"),
                ()->requiredEachFieldTest("password", true, "비밀번호")
        );
    }
    
    void requiredEachFieldTest(String name, boolean isNull, String message){
        setData(); // 값 초기화
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            if (name.equals("password")){
                setParam("password", isNull ? null : "   ");
            }else { //이메일
                setParam("email", isNull ? null : "   ");
            }
            loginService.process(request);
        }, name + "TEST");
        
        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), name + ", keyword: " + message + "TEST");
        //실패할 때 메세지 출력->예외 발생 위치 파악 위함
    }

    @Test
    @DisplayName("이메일로 회원이 조회되는지 검증, 검증 실패 시 BadRequestException 발생")
    void memberExistTest() {
        //회원가입이 우선되어야 함 -> 로그인 정보 비교
        setParam("email", "***" + form.getEmail()); //테스트 실패를 위한 이메일 값 변경
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            loginService.process(request);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @Test
    @DisplayName("PW 검증, 검증 실패 시 BadRequestException")
    void passwordCheckTest() {
        setParam("password", "***" + form.getPassword());
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
           loginService.process(request); 
        });
        
        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @AfterEach
    void destroy() {
        //dbSession.rollback(); //테스트 수행 후 롤백 수행, 시퀀스 번호는 롤백해도 계속 증가됨
    }
}