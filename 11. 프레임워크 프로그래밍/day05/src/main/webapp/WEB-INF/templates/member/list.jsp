<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h1>회원 목록</h1>
<form:form method="get" autocomplete="off" modelAttribute="memberSearch">
    가입일 조회(예: 20240716)<br>
    <form:input path="sDate" />
    <form:errors path="sDate" />
    <%--에러 코드 연동, 커스텀 태그--%>
    ~
    <form:input path="eDate" />
    <form:errors path="eDate" />
    <button type="submit">검색하기</button>
</form:form>