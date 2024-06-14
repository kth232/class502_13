<%@ page contentType="text/html charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:choose>
    <c:when test="${param.age < 8}">
        유치원생
    </c:when>
    <c:when test="${param.age < 14}">
        초등학생
    </c:when>
    <c:when test="${param.age < 17}">
        중학생
    </c:when>
    <c:when test="${param.age < 20}">
        고등학생
    </c:when>
    <c:otherwise>
        성인
    </c:otherwise>
</c:choose>
<%--http://localhost:3000/day05/exam05/ex04.jsp?age=9--%>