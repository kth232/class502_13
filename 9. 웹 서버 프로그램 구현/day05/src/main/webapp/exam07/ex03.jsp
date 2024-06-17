<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="num" value="123465789.123" />
<%--#패턴: 넘치는 부분은 비워둠/ 0패턴: 넘치는 부분은 0으로 채움--%>
#,###.#####: <fmt:formatNumber value="${num}" pattern="#,###.#####" /><br>
0,000.00000: <fmt:formatNumber value="${num}" pattern="0,000.00000" /><br>