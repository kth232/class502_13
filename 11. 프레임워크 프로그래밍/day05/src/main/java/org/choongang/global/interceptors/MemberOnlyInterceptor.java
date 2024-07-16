package org.choongang.global.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class MemberOnlyInterceptor implements HandlerInterceptor {
    //시점 별로 공통 처리 수행 가능, 시점 구분 주의

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle()");

        HttpSession session = request.getSession(); //세션 객체 가져오기
        if(session.getAttribute("member") == null) { //로그인 상태인 경우
            return true; //컨트롤러 빈 메서드 실행
        }
        response.sendRedirect(request.getContextPath() + "/member/login");

        return false; //미로그인 상태
        //true이면 컨트롤러 메서드 실행됨, false이면 실행 안됨 -> 화면 안보임
    } //컨트롤러 실행 전 공통 처리, 통제

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("message", "postHandle"); //속성값을 뷰 페이지에 전달
        log.info("postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //응답 후 메서드 출력
        log.info("afterCompletion()");
    } //정상 출력 시 ex =null
}
