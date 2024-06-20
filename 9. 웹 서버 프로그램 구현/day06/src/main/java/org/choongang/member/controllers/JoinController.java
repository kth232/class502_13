package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //requestDispatcher로 버퍼 치환, 페이지 이동
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp");
        rd.forward(req, resp);
    } //회원가입 양식 ->POST로 넘기면 데이터 처리함

    @Override //회원가입 처리
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JoinService service = MemberServiceProvider.getInstance().joinService();
            service.process(req); //사용자가 넘겨준 데이터=req / 내부에서 처리해서(service) 각 DTO에 넣어줌
            go(req.getContextPath()+"/member/login", "parent", resp);
            //resp.sendRedirect(req.getContextPath()+"/member/login"); //현재 창에서 이동하는 것이기 때문에 히든 프레임 안으로 이동해버림
        } catch (CommonException e) {
            alertError(e, resp);
        }
    }
}
