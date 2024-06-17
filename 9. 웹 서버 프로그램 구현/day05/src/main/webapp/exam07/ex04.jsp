<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="date" value="<%=new Date()%>" />
<%--지역화--%>
<h2>KOREA</h2>
<fmt:setLocale value="ko_kr" />
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br>
금액: <fmt:formatNumber value="100000000" type="currency" /><br>

<h2>AMERICA</h2>
<fmt:setLocale value="en_us" />
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br>
금액: <fmt:formatNumber value="100000000" type="currency" /><br>

<h2>JAPAN</h2>
<fmt:setLocale value="ja_jp" />
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br>
금액: <fmt:formatNumber value="100000000" type="currency" /><br>