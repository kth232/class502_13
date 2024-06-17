<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:set var="num" value="100" />
<util:linebox color="#6799FF" >
    <h2>HELLO</h2>
    ${num}<br>
    <c:url value="/member/join" />
</util:linebox>

<util:linebox2 color="#D1B2FF" >
    <h2>HELLO</h2>
    ${num}<br>
    <c:url value="/member/join" />
    <%--tagdependency 속성은 모두 문자로만 해석--%>
</util:linebox2>