package org.choongang.global.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    //HttpServletRequestWrapper는 생성자 매개변수로 HttpServletRequest를 받아와야 함
    public CommonRequestWrapper(ServletRequest req) {
        super((HttpServletRequest) req); //상위클래스와 자료형 맞추기 위해 형변환 필요
        HttpServletRequest request = (HttpServletRequest) req;

        //로그인 상태, 로그인 회원 정보 전역 유지
        boolean isLogin = MemberUtil.isLogin(request);
        Member member = MemberUtil.getMember(request);

        request.setAttribute("isLogin", isLogin);
        request.setAttribute("loggedMember", member);
    }
}
