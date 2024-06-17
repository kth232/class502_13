<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="loginUrl" value="/member/login" />
<%--a 태그 안쪽에 사용해야 함--%>
<a href ="${loginUrl}">login</a>
<a href ="<c:url value="/member/signup" />">join</a>

<form method="POST" action="${loginUrl}">
    email: <input type="text" name="email"><br>
    pW: <input type="password" name="password"><br>
    <button type="submit">submit</button>
</form>