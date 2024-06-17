<%@ tag body-content="empty" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="num1" type="java.lang.Integer" required="true" %>
<%@ attribute name="num2" type="java.lang.Integer" required="true" %>
<%@ variable name-given="maximum" variable-class="java.lang.Integer" scope="AT_END" %>
<%--자료형 정수형으로 명시, 태그가 끝나면 접근--%>
<%
int max = num1 > num2 ? num1 : num2; //두 수 비교해서 더 큰 수 반환
%>

<c:set var="maximum" value="<%=max%>" />