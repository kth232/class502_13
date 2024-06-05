package tests;

import global.exceptions.ValidationException;
import member.controllers.RequestJoin;
import member.services.JoinService;
import member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;

    @BeforeEach
    void init() {
        joinService = new JoinService(new JoinValidator());
    }

    RequestJoin getData() {
        return RequestJoin.builder()
                .email("test" + System.currentTimeMillis() + "@test.org")
                .password("12345678")
                .confirmPassword("12345678")
                .userName("userName")
                .termsAgree(true)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 발생 없음")
    void successTest() {
        assertDoesNotThrow(() -> {
            joinService.process(getData());
        });
    }

    //테스트할 값과 키워드 일치시킬 것!
    @Test
    @DisplayName("필수항목(이메일, 비밀번호, 비밀번호 확인, 회원명, 약관동의) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest() {
        assertAll( //실패한 부분 전부 출력?
                //이메일 검증
                ()->{
                    RequestJoin form = getData();
                    form.setEmail(null);
                    requiredFieldEachTest(form, "email");
                    
                    form.setEmail("   ");
                    requiredFieldEachTest(form, "email");
                },
                //비밀번호 검증
                () -> {
                    RequestJoin form = getData();
                    form.setPassword(null);
                    requiredFieldEachTest(form, "password");

                    form.setPassword("    ");
                    requiredFieldEachTest(form, "password");
                },
                //비밀번호 확인 검증
                () -> {
                    RequestJoin form = getData();
                    form.setConfirmPassword(null);
                    requiredFieldEachTest(form, "confirm password");

                    form.setConfirmPassword("    ");
                    requiredFieldEachTest(form, "confirm password");
                },
                //회원명 검증
                () -> {
                    RequestJoin form = getData();
                    form.setUserName(null);
                    requiredFieldEachTest(form, "userName");

                    form.setUserName("    ");
                    requiredFieldEachTest(form, "userName");
                },
                //약관동의 검증
                () -> {
                    RequestJoin form = getData();
                    form.setTermsAgree(false);
                    requiredFieldEachTest(form, "agree terms");
                }
        );

        /*
        // email 필수 체크 - null, empty value S
        RequestJoin form = getData();
        form.setEmail(null);
        requiredFieldEachTest(form, "email");

        form.setEmail("    ");
        requiredFieldEachTest(form, "email");
        //email 필수 체크 - null, empty value E

        // 비밀번호 필수 체크 - null, empty value S
        form = getData(); form.setPassword(null);
        requiredFieldEachTest(form, "password");

        form.setPassword("    ");
        requiredFieldEachTest(form, "password");
        // 비밀번호 필수 체크 - null, empty value E


        //이메일 필수 검증 S
        ValidationException thrown = assertThrows(ValidationException.class, () -> {
            RequestJoin form = getData();
            // null 체크
            form.setEmail(null);
            joinService.process(form);

            // 빈 문자
            form.setEmail("     ");
            joinService.process(form);
        });
        
        String message  = thrown.getMessage(); //발생한 예외 메세지
        assertTrue(message.contains("email")); //참일 때만 통과
        //이메일 필수 검증 E

        //비밀번호 필수 검증 S
        thrown = assertThrows(ValidationException.class, () -> {
            RequestJoin form = getData();
            form.setUserName(null);
            joinService.process(form);

            form.setPassword("     ");
            joinService.process(form);
        });
        message = thrown.getMessage();
        assertTrue(message.contains("password"));
        //비밀번호 필수 검증 E
    }
    */
    }

    void requiredFieldEachTest(RequestJoin form, String keyword){
        ValidationException thrown = assertThrows(ValidationException.class, ()->{
            joinService.process(form);
        }, keyword + "error!"); //어떤 테스트일지 모를 때 활용하기 위해 매개변수 키워드에 메세지 추가
        String message = thrown.getMessage();
        assertTrue(message.contains(keyword)); //출력될 것을 예상하는 키워드 정의
    }

    @Test
    @DisplayName("비밀번호와 비밀번호 확인 일치 테스트, 검증 실패 시 ValidationException 발생")
    void passwordMatchTest() {

    }
    
    @Test
    @DisplayName("이메일 중복 여부 테스트, 검증 실패 시 DuplicateMemberException 발생")
    void duplicateEmailTest() {

    }

    @Test
    @DisplayName("회원가입 완료 후 실제 데이터베이스에서 조회되는지 검증")
    void memberExistsTest() {
    //가입 처리
    //getData()로 생성한 데이터의 email 항목으로 DB에서 조회
    //조회한 회원 데이터 email과 getData()로 생성한 email이 일치하는지 체크
    //assertEquals(...)
    }
}
