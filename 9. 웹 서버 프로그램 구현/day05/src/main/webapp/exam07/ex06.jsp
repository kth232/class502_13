<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:set var="date" value="<%=new Date()%>" />
seoul: <fmt:formatDate value="${date}" type="both" /><br>

<%--setTimZone은 위에 정의해서 아래 내용 전부 반영되게 만든다--%>
<fmt:setTimeZone value="Europe/London" />
    london: <fmt:formatDate value="${date}" type="both" /><br>

<fmt:setTimeZone value="America/New_York" />
    new york: <fmt:formatDate value="${date}" type="both" /><br>