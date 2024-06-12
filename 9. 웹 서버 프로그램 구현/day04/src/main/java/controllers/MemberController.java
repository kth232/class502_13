package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*") //servlet을 xml에 하는 것보다 애노테이션 형태로 매핑하는 것이 더 간단하다
public class MemberController extends HttpServlet { //HttpServlet 상속

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req); //모드 값 가져오기
        if (mode.equals("signup")) { //signup일 때 signupform 가져오기
            signupForm(req, resp);
        } else if (mode.equals("login")) {
            loginForm(req, resp); //login일 때 loginform 가져오기
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req); //모드 값 가져오기
        if (mode.equals("signup")) { //signup일 때 signupProcess
            signupProcess(req, resp);
        } else if (mode.equals("login")) { //login일 때 loginProcess
            loginProcess(req, resp);
        }
    }

    private String getMode(HttpServletRequest req){
        String uri= req.getRequestURI(); //사용자가 요청한 url
        String[] uris= uri.split("/"); // "/"를 기준으로 주소 쪼개서 배열에 저장
        String mode = uris.length > 0 ? uris[uris.length -1]: ""; //배열에 저장된 값 중 가장 뒤에 있는 값 가져오기, 없을 때는 빈 문자열을 담아 NullPointException 방지
        return mode;
    }
    
    //회원가입 양식
    private void signupForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{ //doPost에서 전가시키고 있기 때문에 따로 처리하지 않고 넘겨도 됨(어딘가 처리하는 곳이 있기 때문)
        resp.setContentType("text/html;charset=UTF-8"); //content-type 명시, 한글 깨짐 방지
        PrintWriter out = resp.getWriter();
        out.println("<h2>SIGNUP<h2>");
    }
    
    //로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>LOGIN<h2>");
    }
    
    //회원 가입 처리
    private void signupProcess(HttpServletRequest req, HttpServletResponse resp){
        
    }
    
    //로그인 처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse resp){
        
    }
}
