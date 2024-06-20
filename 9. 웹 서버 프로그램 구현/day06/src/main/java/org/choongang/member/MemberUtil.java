package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.member.entities.Member;

public class MemberUtil {
    public static boolean isLogin(HttpServletRequest request) {
        //로그인 상태인지 체크하는 함수
        return geMember(request) != null;
    }

    public static Member geMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");

        return member;
    }
}
