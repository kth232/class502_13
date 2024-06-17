<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="color" %>
<%@ attribute name="size" type="java.lang.Integer" required="true" %>
<%--size로 길이 조절, type 속성으로 자료형 지정 가능(기본값: java.lang.String)--%>
<%--
<%=color%>
${color}
--%>
<div style="color: ${color};">
    <%
        for(int i = 0; i < size; i++){
            out.write("-");
        }
    %>
<%--
-------------------------------
--%>
</div>