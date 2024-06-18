<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<%@ attribute name="commonCss" fragment="true" %>
<%@ attribute name="commonJs" fragment="true" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/static/css/" />
<c:url var="jsUrl" value="/static/js/" />
<%-- 공통 레이아웃 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>
            <c:if test="${!empty title}">
                ${title} -
            </c:if>
            <fmt:message key="SITE_TITLE" />
        </title>
        <%--attribute로 설정한 값으로 대체함--%>
        <link rel="stylesheet" type="text/css" href="${cssUrl}style.css">
        <jsp:invoke fragment="commonCss" />
        <%--특정 레이아웃의 공통부분 가져옴, 따로 정의하지 않으면 나오지 않음--%>
        <c:if test="${addCss != null}">
            <c:forEach var="cssFile" items="${addCss}">
                <link rel="stylesheet" type="text/css" href="${cssUrl}${cssFile}.css">
            </c:forEach>
        </c:if>
        <script src="${jsUrl}common.js"></script>
        <jsp:invoke fragment="commonJs" />
        <c:if test="${addScript != null}">
            <c:forEach var="jsFile" items="=${addScript}">
                <script src=${jsUrl}${jsFiel}.js></script>
            </c:forEach>
        </c:if>
    </head>
    <body>
        <header>
            <%-- 교체되는 부분 --%>
            <jsp:invoke fragment="header" />
            <%-- <h2>site top part</h2> --%>
        </header>
        <main>
            <jsp:doBody />
        </main>
        <footer>
            <%-- 교체되는 부분 --%>
            <jsp:invoke fragment="footer" />
            <%-- <h2>site bottom part</h2> --%>
        </footer>
    </body>
</html>