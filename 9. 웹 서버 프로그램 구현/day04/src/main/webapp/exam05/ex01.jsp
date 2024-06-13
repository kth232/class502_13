<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>
<h2>ex01.jsp - top</h2>
<%
    RequestDispatcher rd = request.getRequestDispatcher("ex02.jsp");
    //rd.forward(request, response);
    rd.include(request, response);
%>
<h2>ex01.jsp - bottom</h2>