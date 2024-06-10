package test;

import com.github.javafaker.Faker;
import global.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given; //BDD(Behavior-Driven Development): 행위 주도 개발
import static org.mockito.Mockito.mock;

@DisplayName("login service function test")
public class LoginServiceTest { //테스트 케이스 = 테스트 설계
    
    private LoginService loginService;
    private HttpServletRequest request; //사용자 요청
    private Faker faker; //가짜 데이터 무작위 생성(국가별 설정 가능)
    
    @BeforeEach //모든 테스트마다 각 단위별 실행
    void init() {
        loginService = new LoginService(new LoginValidator()); //테스트 실행 할 때마다 초기화

        //인터페이스 ->구현체 없음->서버 환경 필요
        //->mock HttpServletRequest 모의 객체 생성
        request = mock(HttpServletRequest.class); //class 클래스: 정보성 객체
        faker = new Faker(Locale.KOREAN); //한국  가짜 데이터 무작위 생성

        //스텁(stub): 가짜 데이터, 해당 parameter를 가져올 때 설정한 값을 리턴함
        //given(request.getParameter("email")).willReturn("test01@test.org");
        //given(request.getParameter("password")).willReturn("12345678");

        //지정한 값을 리턴하는 대신에 익셉션을 발생하게 설정
        //given(request.getParameter("123")).willThrow(IllegalArgumentException.class);
    }

    void setParamData(String name, String value) {
        given(request.getParameter(name)).willReturn(value);
    }
    void setSuccessData() {
        String password = faker.regexify("\\D{8}").toLowerCase(); //알파벳, 숫자, (_) 사용한 8자리 랜덤 PW 데이터 생성
        setParamData("email", faker.internet().emailAddress()); //무작위 이메일 주소 데이터 생성
        setParamData("password", password);
    }

    @Test
    @DisplayName("login 성공 시 예외 발생 없음")
    void successTest() {
        assertDoesNotThrow(()->{
            setSuccessData();
            loginService.process(request);
        });
    }

    @Test
    @DisplayName("필수 항목(ID, PW) 검증, 검증 실패 시 ValidationException 발생")
    void requiredFieldTest() {
        assertAll( //한꺼번에 검증 수행
                //email 검증
                () -> reguiredFieldEachTest("email", "email"),
                //PW 검증
                () -> {
                    setParamData("email", faker.internet().emailAddress()); //이메일 넣어줘서 비번 검증까지 이어지도록 만들기
                    reguiredFieldEachTest("password", "password"); //LoginValidator의 checkRequired와 일치해야 함
                }
        );
        /*
        //ID 필수 항목 검증 -> null, " "
        ValidationException thrown = assertThrows(ValidationException.class, ()->{
            setParamData("email", faker.internet().emailAddress()); //이메일을 검증하는 거지만 PW가 없기 때문에 예외 발생으로 통과되면 안되는데 테스트 통과됨
            loginService.process(request);
        }); // 중간에 검증 실패하면 멈춤

        String message = thrown.getMessage();
        assertTrue(message.contains("email")); //값이 true인지 검사
         */
    }
    
    void reguiredFieldEachTest(String name, String message) {
        /*
        setParamData("email", null); //값 초기화
        setParamData("password", null);
        */

        ValidationException thrown = assertThrows(ValidationException.class, ()->{
            //null일 때 검증
            loginService.process(request);
            
            //공백일 때 검증
            setParamData(name, "   ");
            loginService.process(request);
        }, message + "test");

        String msg = thrown.getMessage(); //검증 오류 메세지
        System.out.println(msg);
        assertTrue(msg.contains(message), message + "test");
    }

    @Test
    @DisplayName("email로 회원이 조회되는지 검증, 검증 실패 시 ValidationException 발생")
    void memberExistsTest() {

    }

    @Test
    @DisplayName(" PW가 일치하는지 검증, 검증 실패 시 PasswordMismatchException 발생")
    void memberAuthTest() {


    }
}
