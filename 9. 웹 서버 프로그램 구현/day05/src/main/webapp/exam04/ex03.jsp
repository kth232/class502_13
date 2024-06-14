<%@ page contentType="text/html; charset=UTF-8" %>
<%--param 내장 객체를 통해 요청 데이터 값에 직접 접근--%>
${param.num1} + ${param.num2} = ${param.num1 + param.num2}
<%--http://localhost:3000/day05/exam04/ex03.jsp?num1=10&num2=20로 url의 입력값 바로 대입
map형태(이름=값)--%>