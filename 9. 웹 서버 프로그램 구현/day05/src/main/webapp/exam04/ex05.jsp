<%@ page contentType="text/html charset=UTF-8" %>
User-Agent: ${header['User-Agent']}<br>
<%--브라우저 정보 가져오기--%>

JSESSIONID: ${cookie.JSESSIONID.getValue()}<br>
JSESSIONID: ${cookie.JSESSIONID.value}<br>
key1: ${initParam.key1}<br>

URI: ${pageContext.getRequest().getRequestURI()}<br>
URI: ${pageContext.request.requestURI}<br>
<%--축약형, 속성명만 가지고도 조회 가능--%>