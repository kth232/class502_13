<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionUrl" value="/survey/step3" />

<h1>step2</h1>

<form:form method="post" action="${actionUrl}" autocomplete="off" modelAttribute="requestSurvey">
<%--    <form:hidden path="q1"/>--%>
<%--    <form:hidden path="q2"/>--%>
    <%--앞 양식에서 넘겨준 값 hidden으로 전달--%>

    question3: <form:input path="q3" /><br>
    question4: <form:input path="q4" /><br>
    <button type="submit">submit</button>

</form:form>