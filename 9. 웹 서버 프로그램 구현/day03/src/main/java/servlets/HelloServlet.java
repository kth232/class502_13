package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet { //서블릿 구현하는 추상 클래스

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //요청과 응답이 가장 중요한 객체, get 방식
        //super.doGet(req, resp); //제거해야 동작함
        System.out.println("doGet()");

        //모든 서블릿이 공유 가능한 초기 설정 값-context-param
        String common1 = req.getServletContext().getInitParameter("common1");
        String common2 = req.getServletContext().getInitParameter("common2");
        System.out.printf("common1: %s, common2: %s%n", common1, common2);
    }

    /*
    @Override
    public void init() throws ServletException {
        System.out.println("init()");
    }
    */

    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init(config);
        //HelloServlet만 조회 가능
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1: %s, key2: %s%n", key1, key2);
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
