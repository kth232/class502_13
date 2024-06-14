<%@ page contentType="text/html charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--,를 기준으로 쪼개서 순서대로 요소가 item 변수에 대입됨--%>
<c:forEach var="item" items="Apple,Orange,Melon">
    <div>${item}</div>
</c:forEach>