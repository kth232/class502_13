<%@ page contentType="text/html; charset=UTF-8" %>
<h2>ex03.jsp</h2>
<%--HttpServletResponse의 sendRedirect: 지정된 리디렉션 위치 URL을 사용하여 클라이언트에 임시 리디렉션 응답을 보내고 기존 버퍼 지움
페이지 이동: response header에 location 추가됨(주소 이동)
ex03.jsp status code: 302,  ex02.jsp status code: 200
--%>
<%
    response.sendRedirect("ex02.jsp");
%>