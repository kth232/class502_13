package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { //객체 생성할 때 한번만 호출
        System.out.println("init()");
        String key1 = filterConfig.getInitParameter("key1");
        String key2 = filterConfig.getInitParameter("key2");
        System.out.printf("key1: %s, key2: %s%n", key1, key2);
    }

    @Override
    public void destroy() { //객체 소멸될 때 한번만 호출, 자원 해제 담당
        System.out.println("destroy()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //request, response 구현체는 서버에 있음
        //관리가 힘들기 때문에 직접 정의는 지양함->wrapper 클래스 사용하는 게 더 율적
        //System.out.println("CommonFilter-요청 전");
        filterChain.doFilter(new CommonRequestWrapper(servletRequest), servletResponse);
        //System.out.println("CommonFilter-응답 후");
    }
}
