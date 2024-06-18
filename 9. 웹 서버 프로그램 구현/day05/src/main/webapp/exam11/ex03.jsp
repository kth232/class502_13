<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie cookie = new Cookie("key2", "value2");
    cookie.setMaxAge(60 * 60 * 24 * 7);
    //시간을 직접 입력하는 것보다 계산식(초단위)으로 표현하는 것이 관례

    response.addCookie(cookie);
%>