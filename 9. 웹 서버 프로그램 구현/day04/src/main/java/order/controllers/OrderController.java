package order.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //서비스 처리, 데이터를 가져와서 넘겨줌
        req.setAttribute("message", "Processing complete"); //서블릿을 통해서 접근, controller에서 처리된 결과
        //속성: 뷰에게 넘겨줄 값, 뷰에서 사용할 수 있는 데이터

        //출력 처리(view): jsp가 뷰 역할, 처리된 결과 출력
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/order/order.jsp"); //webapp이 경로 기준
        rd.forward(req, resp); //forward: 버퍼 치환
    }
}
