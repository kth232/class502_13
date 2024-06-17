<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="num1" value="1000000000" />
<fmt:formatNumber value="${num1}" /><br>
<fmt:formatNumber value="${mum1}" groupingUsed="false" /><br>
<%--소수점으로 입력해야 %로 표기됨--%>
type: percent - <fmt:formatNumber value="0.25" type="percent" /><br>
<%--지역화로 원화 표기--%>
type: currency - <fmt:formatNumber value="10000" type="currency" /><br>
