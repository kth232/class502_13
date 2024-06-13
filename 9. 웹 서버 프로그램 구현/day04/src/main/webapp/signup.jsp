<%@ page contentType="text/html; charset=UTF-8" %>
<%--스크립틀릿: _jspService 지역변수, 메서드 정의 불가--%>
<%
    int num1 = 100;
    int num2 = 200;
    int result = num1 + num2;
    out.write("result=" + result);
    //바로 번역되기 때문에 out.write 작성 가능

    //정의된 멤버변수, 메서드 접근 가능
    out.write("<br>name: "+ name); //페이지에 출력
    print(); //콘솔창에 출력
%>
<br>
<!--html 주석, 주석 안의 내용이 배제되어 화면엔 안나오지만 번역 결과에는 반영됨, 컴파일 시 제거됨--->
<%--표현문: 메서드 지역 내에 번역--%>
<%=num1%> + <%=num2%> = <%=result%>

<%--선언문: 멤버변수, 클래스명 바로 아래쪽에 번역됨, 메서드 정의 가능, 선언만 한 상태--%>
<%!
     String name = "lee";
     void print() {
        System.out.println(name); //콘솔창에 출력
        //out 내장객체 사용 불가
     }
%>
<%--JSP 주석: 번역 과정에서 제거됨(jsp파일에서 java파일이 될 때)--%>