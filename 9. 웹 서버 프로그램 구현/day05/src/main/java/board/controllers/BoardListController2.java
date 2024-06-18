package board.controllers;

import board.entities.BoardData;
import board.services.BoardInfoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list2/*") //*: 게시판 ID로 사용(/board/list만 고정)
public class BoardListController2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //모델 역할
        //request 객체의 setAttribute 속성으로 데이터를 넘겨준다
        BoardInfoService service = new BoardInfoService();
        List<BoardData> items = service.getList();
        
        req.setAttribute("items", items);
        req.setAttribute("addCss", new String[] {"board/style.css", "board/list2"});
        req.setAttribute("addScript", List.of("board/common.js", "board/list2"));
        //css 동적 추가
        
        //뷰에 연결, 버퍼 치환
        //직접 접근은 안되지만 서블릿을 통해서는 접근 가능
        //속성 설정은 반드시 requestDispatcher 상단에 정의해야 함
        //출력 완료 시 속성 반영 안되기 때문
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list2.jsp"); //=뷰
        rd.forward(req, resp);
        
    } //직접 JSP파일에 접근하지 못하도록 막음->jsp파일을 WEB-INF 폴더 내에 생성함
}
