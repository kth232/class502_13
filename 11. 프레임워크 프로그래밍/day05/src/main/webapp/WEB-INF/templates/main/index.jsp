<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="loginUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="logoutUrl" value="/member/logout" />
<c:url var="mypageUrl" value="/mypage" />


<h1>main page</h1>
<%--${isLogin}--%>
<%--${loggedMember}--%>
<%--로그인 했을 때}--%>
<c:if test="${isLogin}">
    <spring:message code="LOGIN_MSG">
        <spring:argument value="${loggedMember.userName}" />
        <spring:argument value="${loggedMember.email}" />
    </spring:message>
    <button type="button">
        <a href="${logoutUrl}"><spring:message code="로그아웃" /></a>
    </button>
    <button type="button">
        <a href="${mypageUrl}"><spring:message code="마이페이지" /></a>
    </button>
</c:if>

<%--로그인 안했을 때}--%>
<c:if test="${!isLogin}">
<div class="button-group">
<button type="button">
    <a href="${joinUrl}"><spring:message code="회원가입" /></a>
</button>
<button type="button">
    <a href="${loginUrl}"><spring:message code="로그인" /></a>
</button>
</div>
</c:if>