<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--번역 과정에서 알림, 스크립트 실행 막음--%>
<c:set var="html" value="<script>alert('alert');</script" />
<%--
${html}
--%>
<c:out value="${html}" />
<c:out value="${str}" default="no value" /><br>
<c:out value="<h2>title</h2>" escapeXml="false" />
<%--default: 기본값, escapeXml: html 해석 방지(문자열로 바꿔줌)->보안 목적--%>