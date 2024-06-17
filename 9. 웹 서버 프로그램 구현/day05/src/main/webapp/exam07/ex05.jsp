<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>


<c:set var="date" value="<%=new Date()%>" />
seoul: <fmt:formatDate value="${date}" type="both" /><br>

<%--태그 열고 닫아서 감싼다--%>
<fmt:timeZone value="Europe/London">
    london: <fmt:formatDate value="${date}" type="both" /><br>
</fmt:timeZone>
<fmt:timeZone value="America/New_York">
    new york: <fmt:formatDate value="${date}" type="both" /><br>
</fmt:timeZone>