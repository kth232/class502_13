<%@ page contentType ="text/html; charset=UTF-8" %>
<%--한글 깨짐 방지 위해 추가--%>
<form method="post" action="board_ps.jsp"> <%--post 방식(바디에 입력값 담김), 작성하면 board_ps.jsp 열림--%>
    title: <input type="text" name="subject"><br> <%--name 속성으로 조회하기 때문에 중요함--%>
    contents: <textarea name = "content"></textarea><br>
    <button type ="submit">작성하기</button>
</form>