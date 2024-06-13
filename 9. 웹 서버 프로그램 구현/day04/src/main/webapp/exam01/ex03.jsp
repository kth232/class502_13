<%@ page contentType="text/html; charset=UTF-8" %>
<%--error 발생 시 보여줄 error 페이지 지정--%>
<%@ page errorPage="error.jsp" %>
<%
    int num1 = 0;
    int num2 = 10;
    int result = num2 / num1;
    //error 발생(ArithmeticException)
%>