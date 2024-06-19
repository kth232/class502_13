package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //requestDispatcher로 버퍼 치환, 페이지 이동
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp");
        rd.forward(req, resp);
    } //회원가입 양식

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    } //회원가입 처리
}
