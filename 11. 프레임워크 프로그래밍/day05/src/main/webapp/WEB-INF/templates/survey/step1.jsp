<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionUrl" value="/survey/step2" />

<h1>step1</h1>

<form:form method="post" action="${actionUrl}" autocomplete="off" modelAttribute="requestSurvey">
    question1: <form:input path="q1" /><br>
    question2: <form:input path="q2" /><br>
    <button type="submit">next</button>

</form:form>