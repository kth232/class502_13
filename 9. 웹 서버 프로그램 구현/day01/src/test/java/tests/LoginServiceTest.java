package tests;

import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoginServiceTest {
    private LoginService loginService;
    private HttpServletRequest request;

    @BeforeEach
    void init() {
        loginService = new LoginService();
    } //테스트 전 필요할 때마다 객체 생성

    @Test
    @DisplayName("login 성공 시 예외 발생 없음")
    void successTest() {
        assertDoesNotThrow(()->{ //exception이 발생하지 않는지 확인
            loginService.process(request); //사용자 입력값 넘어옴, 인터페이스, 구현체가 없기 때문에 가짜 객체 필요함
            
        });

    }
}
