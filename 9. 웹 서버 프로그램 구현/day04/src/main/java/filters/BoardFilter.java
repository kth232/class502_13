package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/*
@WebFilter(value="/board",
        initParams = {
                @WebInitParam(name="k1", value="value1"),
                @WebInitParam(name="k2", value="value2")
}) */
public class BoardFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //필터는 요청과 응답을 걸러주는데 실행 시점이 정해져있음, 요청과 응답 전후 사용됨
        //필터는 용도에 따라 여러 개를 사용할 수도 있음

        System.out.println("BoardFilter-요청 전");
        chain.doFilter(request, response); //다음 필터 또는 서블릿의 처리 메서드 실행
        System.out.println("BoardFilter-응답 후");
    }
}
