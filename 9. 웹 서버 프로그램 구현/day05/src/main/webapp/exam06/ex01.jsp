<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:catch var="e">
    <%--try-catch문과 비슷함, 오류 캐치
    오류가 발생하지 않으면 e=null/발생하면 e에 객체 담김--%>
<%
    String str = null;
    str.toUpperCase();
    //nullpoitnException 발생
%>
</c:catch>
<c:if test="${e != null}">
    <%--error message: ${e.getMessage()}
    출력이 목적이기 때문에 속성명으로 입력해도 getter 출력(get() 생략 가능)--%>
    error message: ${e.message}
</c:if>