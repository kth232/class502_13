<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="loginUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="logoutUrl" value="/member/logout" />

로그인 상태: ${isLogin}<br>

<%-- 미로그인 상태 --%>
<util:GuestOnly>
    <a href="${loginUrl}">로그인</a>
    <a href="${joinUrl}">회원가입</a>
</util:GuestOnly>

<%--로그인 상태--%>
<util:MemberOnly>
    ${loggedMember.userName}(${loggedMember.email})님 로그인...
    <a href="${logoutUrl}">로그아웃</a>
</util:MemberOnly>

<%--로그아웃 상태, session Scope로 범위 제한--%>
<%--
<c:if test="${sessionScope.member == null}">
    <a href="${loginUrl}">login</a>
    <a href="${joinUrl}">join</a>
</c:if>
--%>

<%--로그인 상태--%>
<%--
<c:if test="${sessionScope.member != null}">
    ${sessionScope.member.userName}(${sessionScope.member.email}) 님 로그인
    <a href="${logoutUrl}">logout</a>
</c:if>
--%>

<%--
${member}값이 나오면 로그인 상태, 없으면 로그아웃 상태
회원 데이터 범위 제한 ->sessionScope 사용
로그아웃은 세션을 비우면 됨
<%
    pageContext.setAttribute("member", "..");
    request.setAttribute("member", "..");
%>
--%>