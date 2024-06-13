<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.net.*" %>
<h2>ex03.jsp</h2>
<%--요청 처리 중에 버퍼가 값을 같이 전달
원래 한글은 깨져서 출력되는 게 맞지만 jsp 버전 업그레이드로 깨지지 않고 출력됨
encoder로 16진수 형태 출력--%>
<%
    String key1 = URLEncoder.encode("이름1", "UTF-8");
%>

<jsp:forward page="ex04.jsp">
    <jsp:param name="key1" value="<%=key1%>" />
    <jsp:param name="key2" value="value2" />
</jsp:forward>
