<%@ tag body-content="tagdependent" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="color" %>
<div style="border: 6px double ${color}; padding: 30px;" >
    <jsp:doBody />
    <%--안쪽 내용물 대체--%>
</div>