<%@ page contentType="text/html charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--delims에 있는 특수기호 기준으로 데이터 쪼개서 요소 출력--%>
<c:forTokens var="item" items="Mango#Grape+Banana" delims="#+">
    <div>${item}</div>
</c:forTokens>