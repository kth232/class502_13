<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>
<jsp:useBean id="item" class="board.entities.BoardData" scope="request" />
<jsp:setProperty name="item" property="*"/>
<%--*로 모든 값 조회 가능--%>

<%--
<jsp:setProperty name="item" property="subject" />
<jsp:setProperty name="item" property="content" />
<jsp:setProperty name="item" property="poster" param="writer"/>
--%>
<%--request 범위 조회, 자동으로 양식 데이터 값을 바로 넣어줌, 단 프로터피와 name이 동일해야 함(매칭 주의)
만약 name이 다르다면 param으로 매칭할 값을 알려주면 됨--%>

title: ${item.subject}<br>
content: ${item.content}<br>
poster: ${item.poster}<br>