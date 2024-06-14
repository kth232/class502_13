<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>POST LIST</h2>

<ul>
<%--var="태그 내에서 사용할 변수" 속성명="${리스트, 서블릿에서 넘겨준 값}" varStatus: 반복 상태 확인 / current: 반복되는 데이터 요소 확인--%>
<c:forEach var="data" items="${items}" varStatus="status">
    <li>
        ${data.subject} / ${data.poster} / ${data.content} / ${data.regDt}
            <div>
                index: ${status.index} / count: ${status.count} / first: ${status.first} / last: ${status.last} / current: ${status.current}
            </div>
        <%--getter함수지만 변수명만 써도 가능(축약형), 항목을 선택해서 하나씩 조회--%>
    </li>
</c:forEach>
</ul>
<%--직접 접근 막음->WEB-INF 폴더 안에 생성--%>