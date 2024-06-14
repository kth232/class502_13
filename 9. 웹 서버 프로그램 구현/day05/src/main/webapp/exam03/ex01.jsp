<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="items" class="java.util.ArrayList" scope="request"/>
<%--${items}--%>
<%
    //JSP 페이지 내에서 데이터를 사용할 목적으로 만듦, 속성 형태로 넘겨줘야 함, scope로 속성 저장할 범위 설정
    //scope='page'일 때 조회 가능, 기본값=page
    /*
    ArrayList data = (ArrayList)pageContext.getAttribute("items");
    data.add("A");
    data.add("B");
    System.out.println(data);
    */

    //scope='page'일 때 request 범위는 조회 안됨, request 범위로 바꿔주면 조회 됨
    ArrayList data = (ArrayList)request.getAttribute("items");
    data.add("C");
    data.add("D");
    System.out.println(data);
%>