<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.*" %>
<%
    BoardData board = BoardData.builder()
            .subject("title")
            .content("content")
            .build();

    session.setAttribute("board", board);
    session.setAttribute("title", "title!");
%>