package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {
    //의존 역전 원칙: 하위 계층이 상위 계층 의존 ->추상화
    private Validator<HttpServletRequest> validator;
    private MemberMapper mapper;

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(HttpServletRequest request) {
        //로그인 유효성 검사
        validator.check(request);

        //로그인 처리-회원 정보 조회, 사용자 개인의 로그인 정보를 세션에 유지
        String email = request.getParameter("email");
        Member member = mapper.get(email); //이메일 검증은 이미 끝난 상태

        //로그인 정보는 자신만 사용하기 위해 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("member", member); //해당 메서드가 호출되는 게 중요함
    }
}
