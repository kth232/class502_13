<%@ page contentType="text/html; charset=UTF-8" %>
<%
    //pageContext.setAttribute("key1", "value1");
    request.setAttribute("key1", "value1");
%>
<jsp:include page="ex02.jsp" />

<%
    //String ke1 = (String)pageContext.getAttribute("key1");
    String key1 = (String)request.getAttribute("key1");
%>
<%--pageContext: jsp 페이지 내에서만 접근 가능
request: 같은 요청 범위 내에서 접근 가능--%>

<div>
ex01-key1: <%=key1%>
</div>