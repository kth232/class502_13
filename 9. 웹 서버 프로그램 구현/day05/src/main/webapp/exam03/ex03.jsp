<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>
<jsp:useBean id="item" class="board.entities.BoardData" />
<jsp:setProperty name="item" property="subject" value="title" />
<jsp:setProperty name="item" property="content" value="content" />
<jsp:setProperty name="item" property="poster" value="poster" />
<%--setter call, 자동으로 양식 데이터 값을 바로 넣어줌, 단 프로터피와 name이 동일해야 함(매칭 주의)--%>

<%--getter call, 메서드 직접 호출 가능, 축약형도 가능--%>
title: ${item.subject}<br>
content: ${item.content}<br>
poster: ${item.poster}

<%--
title: ${item.getSubject()}<br>
content: ${item.getContent()}<br>
poster: ${item.getPoster()}

title: <jsp:getProperty name="item" property="subject" /><br>
content: <jsp:getProperty name="item" property="content" /><br>
poster: <jsp:getProperty name="item" property="poster" />
--%>
