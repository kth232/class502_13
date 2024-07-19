<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="actionUrl" value="/member/join" />

<!--커맨드 객체가 속성으로 자동 추가됨
value값에 넣어서 완성시킴-> 입력값이 날아가지 않게 함
-> 스프링이 자동 완성 태그(커스텀 태그) 제공
modelAttribute="requestJoin" ->어떤 모델을 사용하는지 커맨드 객체 명시해주기-->
<h1>
    <spring:message code="회원가입" />
    <%--양이 많아지면 영어로 작성하기 어려움->한글로 작성하는 것이 편할 듯--%>
</h1>
<form:form method="POST" action="${actionUrl}" autocomplete="off" modelAttribute="requestJoin">
    <dl>
        <dt>
            <spring:message code="이메일" />
        </dt>
        <dd>
<%--            <input type="text" name="email" value="${requestJoin.email}">--%>
            <form:input path="email" type="email" />
            <form:errors path="email" />
            <%--cssClass="input-txt" cssStyle="border-color: gold;"--%>
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호"/>
        </dt>
        <dd>
<%--            <input type="password" name="password">--%>
            <form:password path="password" />
            <form:errors path="password" />
            <%--errors 객체와 연동됨, 태그 직접 설정 가능, 기본(span)--%>
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호_확인"/>
        </dt>
        <dd>
<%--            <input type="password" name="confirmPassword">--%>
            <form:password path="confirmPassword" />
            <form:errors path="confirmPassword" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="회원명"/>
        </dt>
        <dd>
<%--            <input type="text" name="userName" value="${requestJoin.userName}">--%>
            <form:input path="userName" />
            <form:errors path="userName" />
        </dd>
    </dl>

    <dl>
        <dt>
            <spring:message code="약관동의" />
        </dt>
        <dd>
<%--            <input type="checkbox" name="agree" value="true" id="agree">--%>
<%--            <label for="agree">회원가입 약관에 동의합니다.</label>--%>
            <form:checkbox path="agree" value="true" label="회원가입 약관에 동의합니다." />
            <form:errors path="agree" element="div" delimiter="" />
            <%--필드 에러 명시--%>
        </dd>
    </dl>
    <button type="reset">
        <spring:message code="다시_입력"/>
    </button>
    <button type="submit">
        <spring:message code="가입하기" />
    </button>
</form:form>