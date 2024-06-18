<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<%
    String name;
    String value;

    Enumeration en = session.getAttributeNames(); //반복자 패턴
    int i = 0;

    while (en.hasMoreElements()) {
        i++;
        name = en.nextElement().toString();
        value = session.getAttribute(name).toString(); //setAttribute()로 넣은 값 가져옴
        out.println("설정된 세션의 속성 이름 [ " + i + " ] : " + name + "<br>");
        out.println("설정된 세션의 속성 값 [ " + i + " ] : " + value + "<br>"); //out.println -> 웹 페이지에 출력
    }
%>