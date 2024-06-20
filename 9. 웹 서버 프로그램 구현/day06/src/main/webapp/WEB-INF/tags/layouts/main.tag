<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<c:url var="cssUrl" value="/static/css/" />
<c:url var="jsUrl" value="/static/js/" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <h1>★MAIN LAYOUT TOP PART★</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <h1>★MAIN LAYOUT BOTTOM PART★</h1>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>