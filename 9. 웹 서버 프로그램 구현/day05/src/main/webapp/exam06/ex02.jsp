<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>ex02.jsp</h2>
<c:redirect url="ex03.jsp">
<%--지정된 주소 이동(respone header-location), 이동 기록 남음--%>
    <c:param name="key1" value="value1" />
    <c:param name="key2" value="value2" />
    <%--쿼리스트링 형태로 url에 추가--%>
</c:redirect>