package org.choongang.member.validators;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator, EmailValidator {
    private MemberMapper mapper;

    public JoinValidator(MemberMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void check(RequestJoin form) {
        /* 필수 항목 검증->이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의
        * 검증할 항목이 있을 땐 추가, 없을 땐 제거*/
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean termsAgree = form.isTermsAgree();

        checkRequired(email, new BadRequestException("enter your EMAIL"));
        checkRequired(password, new BadRequestException("enter your PW"));
        checkRequired(confirmPassword, new BadRequestException("confirm your PW"));
        checkRequired(userName, new BadRequestException("enter your name"));
        checkTrue(termsAgree, new BadRequestException("agree terms"));

        //비밀번호, 비밀번호 확인 일치 여부
        checkTrue(password.equals(confirmPassword), new BadRequestException("비밀번호가 일치하지 않습니다."));

        // 이메일 형식 체크
        if (!checkEmail(email)) {
            throw new BadRequestException("이메일 형식이 아닙니다.");
        }

        //비밀번호 자리수 체크
        checkTrue(password.length() >= 8, new BadRequestException("비밀번호는 8자리 이상 입력해주세요."));

        //이미 가입된 회원인지 체크
        //기존 값을 없애고 다시 만들어진 값으로 대체(캐시 비우기)
        checkTrue(mapper.exist(email) == 0L, new DuplicatedMemberException());
    }
}
