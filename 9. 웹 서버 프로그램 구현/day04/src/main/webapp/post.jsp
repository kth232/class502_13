<%@ page contentType="text/html; charset=UTF-8" %>
<h1>게시글 작성</h1>
<form method="post" action="post_ps.jsp">
    title: <input type='text' name='subject'><br>
    content: <textarea name='content'></textarea><br>
    <button type='submit'>submit</button>
</form>

<%-- <% %> 스크립틀릿(_jspService 지역변수로 번역), 메서드 정의 불가 --%>
<%
    int num1 = 100;
    int num2 = 200;
    //int result = num1 + num2;
    int result = add(num1, num2);
    System.out.println(result);
    /*
    int minus(int num1, int num2){
        return num1 - num2
    }
    */
%>

<%-- <%! %> 선언문(다른 지역에 정의됨-멤버 변수), 메서드 정의 가능 --%>
<%!
    int num1 = 10;
    int num2 = 20;

    int add(int num1, num2) {
        return num1 + num2;
    }
%>