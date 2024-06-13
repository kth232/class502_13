<%@ page contentType="text/html; charset=UTF-8"%>
<%--에러 발생 시 내장객체 exception 변수 사용--%>
<%@ page isErrorPage="true" %>
<h2>error!</h2>
<%= exception.getMessage() %>
<%
    exception.printStackTrace();
%>