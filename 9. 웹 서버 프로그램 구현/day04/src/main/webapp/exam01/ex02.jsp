<%@ page contentType="text/html; charset=UTF-8" %>
<%--buffer 설정, 기본은 8kb지만 32kb로 변경 가능, 대부분 기본 크기 사용..--%>
<%@ page buffer="32kb" %>
<%--import 설정, 여러 클래스를 가져올 때 나눠서 작성해도 되고 ,로 한번에 작성해도 됨--%>
<%@ page import="java.util.* , java.time.LocalDateTime" %>
<%@ page info="funny JSP practice"%>
<%
    List<String> names = new ArrayList<>();
    names.add("name1");
    names.add("name2");
    out.write(names.toString());

    LocalDateTime now = LocalDateTime.now();
    out.write("<br>" + now.toString());
%>