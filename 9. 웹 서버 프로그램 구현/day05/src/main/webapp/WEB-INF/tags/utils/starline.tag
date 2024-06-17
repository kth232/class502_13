<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="java.util.*" %>
<%@ tag dynamic-attributes="attrs" %>
<%--동적 애트리뷰트: 맵 형태로 값 저장, 다른 자료형 불가, 문자열 형태만 가능--%>
<%
    Map<String, String> attrs = (Map<String, String>) jspContext.getAttribute("attrs");
    String _size = attrs.getOrDefault("size", "0"); //값이 없으면 기본값으로 대체
    int size = Integer.parseInt(_size);
%>
<div style="color: ${attrs.color};">
    <%
        for(int i = 0; i < size; i++){
            out.write("*");
        }
    %>
</div>

<%--
color: ${attrs.color}<br>
size: ${attrs.size}<br>
--%>