<%@ tag body-content="empty" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="num1" type="java.lang.Integer" required="true" %>
<%@ attribute name="num2" type="java.lang.Integer" required="true" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ variable name-from-attribute="var" alias="minimum" variable-class="java.lang.Integer" scope="AT_END" %>
<%--자료형 정수형으로 명시, 태그가 끝나면 접근, 속성명으로부터 가져옴--%>
<%
int min = num1 > num2 ? num2 : num1; //두 수 비교해서 더 작은 수 반환, 지역변수로 사용
%>

<c:set var="minimum" value="<%=min%>" />
<%--접근할 수 있는 속성으로 추가, 변수명을 입력한대로 사용할 수 있음--%>