package org.choongang.global.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*") //모든 요청에 필터 유입
public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(new CommonRequestWrapper(request), response); //변수명 잘 확인하고 사용하기!
    }
}
