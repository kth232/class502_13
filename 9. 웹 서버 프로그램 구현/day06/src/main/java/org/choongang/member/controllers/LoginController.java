package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //requestDispatcher로 버퍼 치환, 페이지 이동, 매개변수 잘 확인하기
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
    } //로그인 양식

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    } //로그인 처리
}
