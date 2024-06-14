<%@ page contentType="text/html; charset=UTF-8" %>
<%
    pageContext.setAttribute("num", 10);
    //변수와 동일하게 사용
%>
${100 + 200}<br>
${num == 10 ? "num 10" : "no num 10"}