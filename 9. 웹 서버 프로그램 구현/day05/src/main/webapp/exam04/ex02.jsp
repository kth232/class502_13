<%@ page contentType="text/html; charset=UTF-8" %>
<%
    application.setAttribute("num", 100);
    //범위 제한 없이 변수처럼 사용 가능

    request.setAttribute("num", 200);

    pageContext.setAttribute("num", 300);
    //같은 속성(변수명)일 경우 범위 좁을수록 우선 사용

    pageContext.setAttribute("max-num", 1000);
    //- 기호는 변수명 규칙 위반
%>
<%--scope를 통해 해당 범위에 있는 속성 직접 가져오기--%>
pageContext.num : ${pageScope.num}<br>
request.num: ${requestScope.num}<br>
application.num: ${applicationScope['num']}<br>
<%--대괄호를 사용할 땐 문자열로 입력해야 함
변수명 규칙에 맞을 때는 마침표, 규칙에 맞지 않는 경우 대괄호--%>
max-num: ${pageScope['max-num']}