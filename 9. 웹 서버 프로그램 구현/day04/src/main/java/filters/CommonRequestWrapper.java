package filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request); //super와 적절하게 매칭해야 함(매개변수 추가해야 함), wrapper 클래스에 기본 생성자만 있기 때문

        //요청 전 공통 처리 부분
        System.out.println("요청 전 공통 처리 코드..");
        //메서드 재정의로 커스텀한 것도 한 곳에 정의해서 공통으로 처리 가능해짐
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        value = value == null ? value : "★" + value + "★";
        return value;
    }
}
