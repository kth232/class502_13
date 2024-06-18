<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie cookie = new Cookie("key3", "value3");
    cookie.setPath(request.getContextPath());
    cookie.setHttpOnly(true); //자바스크립트로 쿠키 조회 불가
    response.addCookie(cookie);
    //해당 Path의 하위 경로면 다른 경로 내에서도 공유 가능, 데이터 유지 범위 설정
%>