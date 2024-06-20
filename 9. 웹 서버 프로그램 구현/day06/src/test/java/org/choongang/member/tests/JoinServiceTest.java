package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.choongang.global.configs.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("join func test")
public class JoinServiceTest {

    private JoinService service;
    private MemberMapper mapper;

    @BeforeEach
    void init() {
        //초기화, 테스트 전에 한번씩 수행
        //service = new JoinService(new JoinValidator());
        //provider에서 조립한 객체 가져옴
        service = MemberServiceProvider.getInstance().joinService();
        mapper = DBConn.getSession().getMapper(MemberMapper.class);
    }

    RequestJoin getData() {
        Faker faker = new Faker(Locale.ENGLISH); //영어로 된 가짜 데이터 생성
        RequestJoin form = RequestJoin.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress()) //중복 없는 이메일 주소 스텁 생성
                .password(faker.regexify("\\w{8}").toLowerCase()) //스텁 패턴(8자리 이상 소문자로만)
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();

        form.setConfirmPassword(form.getPassword());

        return form;
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 발생하지 않음")
    void successTest() {
        RequestJoin form = getData();
        assertDoesNotThrow(() -> { //실행 결과로 예외 발생 여부 검사
            service.process(form); // getData() 분리
        });

        //가입된 이메일로 회원이 조회 되는지 체크
        Member member = mapper.get(form.getEmail());
        assertEquals(form.getEmail(), member.getEmail()); //실제 값과 기대값이 같은지 검사
    }

    //검증 절차, 필수 항목 확인 절차를 가장 많이 테스트함
    @Test
    @DisplayName("필수 입력항목(email, PW, confirmPw, userNM, agreeTerms) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {
        assertAll( //모든 검증을 실행하고 실패한 검증을 체크함
                () -> requiredEachFieldTest("email", true, "EMAIL"),
                () -> requiredEachFieldTest("email", false, "EMAIL"),
                () -> requiredEachFieldTest("password", true, "PW"),
                () -> requiredEachFieldTest("password", false, "PW"),
                () -> requiredEachFieldTest("confirmPassword", true, "confirm your PW"),
                () -> requiredEachFieldTest("confirmPassword", false, "confirm your PW"),
                () -> requiredEachFieldTest("userName", true, "name"),
                () -> requiredEachFieldTest("userName", false, "name"),
                () -> requiredEachFieldTest("termsAgree", false, "terms")
        );
        /*
        assertThrows(BadRequestException.class, ()->{
           RequestJoin form = getData();
           form.setEmail(null);
           service.process(form);
        });
         */
    }

    void requiredEachFieldTest(String field, boolean isNull, String keyword) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> { //실행 결과 지정한 타입의 예외가 발생하는지 검사
            RequestJoin form = getData();
            if (field.equals("email")) {
                form.setEmail(isNull ? null : "    ");
            } else if (field.equals("password")) {
                form.setPassword(isNull ? null : "    ");
            } else if (field.equals("confirmPassword")) {
                form.setConfirmPassword(isNull ? null : "    ");
            } else if (field.equals("userName")) {
                form.setUserName(isNull ? null : "     ");
            } else if (field.equals("termsAgree")) {
                form.setTermsAgree(false);
            }

            service.process(form);
        }, field + " TEST");

        String message = thrown.getMessage();
        assertTrue(message.contains(keyword), field + "KEYWORD TEST");
    }

    @Test
    @DisplayName("비밀번호와 확인이 일치하지 않는 경우 BadRequestException 발생")
    void passwordMismatchTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            RequestJoin form = getData();
            form.setConfirmPassword(form.getPassword() + "**");
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("이메일이 형식에 맞지 않으면 BadRequestException 발생")
    void emailPatternTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            RequestJoin form = getData();
            form.setEmail("****");
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 형식")); //키워드 일부로 입력, 일치 여부로 검증
    }

    @Test
    @DisplayName("비밀번호 자리수가 8자리 미만이면 BadRequestException 발생")
    void passwordLengthTest() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            Faker faker = new Faker();
            RequestJoin form = getData();
            form.setPassword(faker.regexify("\\w{3,7}").toLowerCase()); // 3~7자리 소문자만, 띄어쓰기 안됨
            form.setConfirmPassword(form.getPassword());
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("8자리 이상"));
    }

    @Test
    @DisplayName("이미 가입된 메일인 경우 DuplicatedMemberException 발생")
    void duplicateEmailTest() {
        MemberServiceProvider provider = MemberServiceProvider.getInstance();
        assertThrows(DuplicatedMemberException.class, () -> {
            RequestJoin form = getData();
            provider.joinService().process(form);
            provider.joinService().process(form); //두번 가입할 때 예외 발생
        });
    }
}
    /*
        assertThrows(DuplicatedMemberException.class, new Executable() {
            @Override
            public void execute() throws Throwable{

            }
        });

        assertThrows() 지역 내부에 정의된 상태
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {

            }
        };

        -- 간소화 --
        Executable executable = () -> {
        };
    */