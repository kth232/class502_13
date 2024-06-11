package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class JoinServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //제거해야 출력됨, 있으면 값 유입 안됨
        
        resp.setContentType("text/html;charset=UTF-8"); //content-type을 설정하지 않으면 서버가 제대로 인식하지 못함
        //resp.setCharacterEncoding("UTF-8"); //한글로 출력하도록 인코딩 설정
        //서블릿 4버전까지, 기본 유니코드 2바이트 형식, 서블릿 6버전부터는 기본 유니코드가 3바이트(UTF-8)
        
        PrintWriter out = resp.getWriter();
        out.println("<h1>SignUp<h1>");
        out.println("<h3><form method='POST' action='join'>");
        out.println("email: <input type ='text' name='email'><br>");
        out.println("password: <input type='password' name='PW'><br>");
        out.println("confirm password: <input type='password' name='confirmPW'><br>");
        out.println("name: <input type='text' name='userNm'><br>");
        out.println("hobby:<br><input type='checkbox' name='hobby' value='hobby1'>hobby1");
        out.println("<input type='checkbox' name='hobby' value='hobby2'>hobby2");
        out.println("<input type='checkbox' name='hobby' value='hobby3'>hobby3");
        out.println("<input type='checkbox' name='hobby' value='hobby4'>hobby4<br>");
        out.println("<button type='submit'>submit</button>");
        out.println("</form><h3>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //제거해야 출력됨
        String email = req.getParameter("email"); //getParameter는 값 1개만 조회함
        String password = req.getParameter("PW");
        String confirmPW = req.getParameter("confirmPW");
        String userName = req.getParameter("userNm");
        String[] hobbies = req.getParameterValues("hobby"); //같은 항목에 여러 개를 선택하는 경우 getParameterValues 사용(+String 배열)

        System.out.printf("email: %s, PW: %s, confirmPW: %s, userName: %s%n", email, password, confirmPW, userName);
        Arrays.stream(hobbies).forEach(s-> System.out.println("hobby: " + s));
    }
}
