package org.choongang.member.validators;


import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //DI-생성자 매개변수
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator { //사실 스프링이 제공하는 부분..

    private final MemberMapper mapper;
    
    @Override
    public void check(RequestJoin form) {
        /**
         * 1. 필수 항목 검증(email, password, confirmPassword, userName, agree)
         * 2. 이메일 중복 여부(가입되어 있는 회원인지 체크)
         * 3. 비밀번호 자리수 체크(최소 8자리)
         * 4. 비밀번호, 비밀번호 확인 일치 여부
         */
        
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean result = form.isAgree();

        //필수 항목 검증
        checkRequired(email, new BadRequestException("이메일을 입력하세요"));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요"));
        checkRequired(confirmPassword, new BadRequestException("비밀번호를 확인하세요"));
        checkRequired(userName, new BadRequestException("회원명을 입력하세요"));
        
        checkTrue(result, new BadRequestException("약관에 동의하세요"));

        //이메일 중복 여부
        checkTrue(mapper.exists(email) == 0L, new BadRequestException("이미 가입된 메일입니다"));

        //비밀번호 자리수 체크
        checkTrue(password.length() >= 8, new BadRequestException("비밀번호는 8자리 이상 입력해주세요"));

        //비밀번호, 비밀번호 확인 일치 여부
        checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호가 일치하지 않습니다"));
    }
}
