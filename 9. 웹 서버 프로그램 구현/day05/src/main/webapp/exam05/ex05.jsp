<%@ page contentType="text/html charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--var: 카운트 변수, 태그 내에서 숫자 대입받음--%>
<c:forEach var="cnt" begin="1" end="10" step="2">
    <div>${cnt} repeat</div>
</c:forEach>