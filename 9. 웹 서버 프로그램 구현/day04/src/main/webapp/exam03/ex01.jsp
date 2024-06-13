<%@ page contentType="text/html; charset=UTF-8" %>
<h2>ex01.jsp</h2>
<jsp:forward page="ex02.jsp" />
<%--ex02.jsp로 이동->페이지는 그대로 있고 서버쪽에서 출력할 때 응답 버퍼를 교체한 것
기존 버퍼 크기보다 큰 데이터를 출력할 경우 자기 페이지 데이터를 먼저 채움-> 가득 채운 버퍼를 일단 출력하고 비움
->다음 버퍼에 forward로 가져온 데이터를 채워서 한번 더 출력(마지막에 치환됨!, forward 사용 시 주의)--%>