<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1>my page</h1>
<h1>${message}</h1>
<spring:message code="LOGIN_MSG">
    <spring:argument value="${member.userName}" />
    <spring:argument value="${member.email}" />
</spring:message>