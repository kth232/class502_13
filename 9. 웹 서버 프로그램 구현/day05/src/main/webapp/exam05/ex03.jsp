<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="num" value="10" />
<c:if test="${num % 2 == 1}">
    홀수
</c:if>
<c:if test="${!(num % 2 == 1)}">
    <%--부정으로 바꿔줌, 복잡한 조건문일 때 if문 사용--%>
    짝수
</c:if>
<br>
${num % 2 == 1 ? '홀수' : '짝수'}
<%--간단한 조건문일 때 삼항조건식--%>