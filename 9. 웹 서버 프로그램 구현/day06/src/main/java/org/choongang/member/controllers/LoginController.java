package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //requestDispatcher로 버퍼 치환, 페이지 이동, 매개변수 잘 확인하기
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp); //forward 방식: 요청한 정보를 그대로 전달, 이동한 페이지에서 요청, 응답 객체를 그대로 사용 가능
    } //로그인 양식 ->POST로 넘겨서 처리

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            LoginService service = MemberServiceProvider.getInstance().loginService();
            service.process(req);
            //예외가 없으면 성공한 것
            
            //이메일 기억하기 처리 S
            //사실 좋은 방법은 아님..
            String email = req.getParameter("Email");
            Cookie cookie = new Cookie("saveEmail", email);
            if (req.getParameter("saveEmail") != null) { //이메일 기억하기 체크
                //7일간 기억하기
                cookie.setMaxAge(60 * 60 * 24 * 7); //초단위
            } else { //체크 해제-쿠키 제거
               cookie.setMaxAge(0);
            }
            resp.addCookie(cookie);
            //이메일 기억하기 처리 E

            go(req.getContextPath()+"/", "parent", resp);
            //실제 주소: http://localhost:3000/day06/index.jsp , 부모창에서 열기
        }catch (CommonException e){
            alertError(e, resp);
        }
    } //로그인 처리
}
