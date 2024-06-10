package exam01;

import com.github.javafaker.Faker;
import global.Mailer;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class) // mockito 확장 기능 추가
public class Ex02Test {
    private LoginService loginService;

    @Mock //모의 객체 생성
    private Mailer mailer; //모의 객체
    private Faker faker; //가짜 데이터

    @Mock //모의 객체 생성
    private HttpServletRequest request;

    @BeforeEach //각 단위마다 테스트
    void init() { //초기화
        loginService = new LoginService(new LoginValidator());
        //mailer = mock(Mailer.class);
        faker = new Faker(Locale.ENGLISH);
        
        //request = mock(HttpServletRequest.class); //모의 객체 생성
        
        //add stub(가짜 데이터)
        given(request.getParameter("email")).willReturn(faker.internet().emailAddress()); //이메일 주소 무작위 데이터
        given(request.getParameter("password")).willReturn(faker.regexify("\\w{8}").toLowerCase()); //알파벳, 숫자, (_)를 사용한 8자리 무작위 PW 데이터
    }

    @Test
    void test1() {
        loginService.setMailer(mailer); //메일러 값 전달
        loginService.process(request);
        String email = request.getParameter("email");
        
        then(mailer).should(only()).send(email); //send 함수가 loginService.process 메서드에서 단 한번만 호출되는지 테스트(호출 여부만 테스트)
    }

    @Test
    void test2() {
        loginService.setMailer(mailer);
        loginService.process(request);
        String email = request.getParameter("email");

        //사용한 인자 검증
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); //인자 캡처 method, String 타입, 실제 호출할 때 전달한 인자를 보관함
        then(mailer).should().send(captor.capture());
        String usedEmail = captor.getValue(); //send method에서 매개변수로 사용한 값
        assertEquals(email, usedEmail); //두 값 일치하는지 확인
    }
}
