<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>ex04.jsp -top</h2>

<%--버퍼에 추가됨, var로 변수 지정하면 속성명으로 주소 담김(출력 x), 변수에 담긴 상태라 다양하게 활용 가능--%>
<%--
<c:import var="html" url="inc.jsp" />
${html}
${html}
--%>
<%--데이터가 url로 넘어감--%>
<c:import url="inc.jsp">
    <c:param name="num1" value="100" />
    <c:param name="num2" value="200" />
</c:import>

<h2>ex04.jsp -bottom</h2>