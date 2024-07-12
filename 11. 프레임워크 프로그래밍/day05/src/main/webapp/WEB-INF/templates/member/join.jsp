<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="actionUrl" value="/member/join" />

<%--<spring:message code="LOGIN_MSG" arguments="유저01, user01" />--%>
<%--arguments: 순서대로 대체됨}--%>
<spring:message code="LOGIN_MSG">
    <spring:argument value="유저01" />
    <spring:argument value="user01" />
</spring:message>

<%--${requestJoin}--%>
<!--커맨드 객체가 속성으로 자동 추가됨
value값에 넣어서 완성시킴-> 입력값이 날아가지 않게 함
-> 스프링이 자동 완성 태그(커스텀 태그) 제공
modelAttribute="requestJoin" ->어떤 모델을 사용하는지 커맨드 객체 명시해주기-->
${commonValue}
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
            <form:input path="email" type="email" cssClass="input-txt" cssStyle="border-color: gold;"/>
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호"/>
        </dt>
        <dd>
<%--            <input type="password" name="password">--%>
            <form:password path="password" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="비밀번호_확인"/>
        </dt>
        <dd>
<%--            <input type="password" name="confirmPassword">--%>
            <form:password path="confirmPassword" />
        </dd>
    </dl>
    <dl>
        <dt>
            <spring:message code="회원명"/>
        </dt>
        <dd>
<%--            <input type="text" name="userName" value="${requestJoin.userName}">--%>
            <form:input path="userName" />
        </dd>
    </dl>
<%--
    <dl>
        <dt>역량</dt>
        <dd>
            <form:radiobuttons path="skill" items="${skills2}" itemLabel="code" itemValue="value" />

            <form:select path="skill">
                <option value=''>* 선택하세요 *</option>
                <form:option value="skill0" label="skill0" />
                <form:options items="${skills2}" itemLabel="code" itemValue="value" />
            </form:select>



            <form:select path="skill">
                <option value="">* 선택하세요 *</option>
                <form:options items="${skills}" />
            </form:select>


            <form:select path="skill" items="${skills}" />
                <!--리스트 자료형으로 하면 멀티값으로 나옴-->
                ${requestJoin.skill[0]}
                <!--배열요소로 값 확인 가능, 태그-->
            <form:checkboxes path="skill" items="${skills}"/>
        </dd>
    </dl>
    <dl>
        <dt>주소</dt>
        <dd>
            <form:input path="addr.zipCode" placeholder="우편번호"/>
            <form:input path="addr.address" placeholder="주소" />
            <form:input path="addr.addressSub" placeholder="나머지 주소"/>
        </dd>
    </dl>
--%>
    <dl>
        <dt>
            <spring:message code="약관동의" />
        </dt>
        <dd>
<%--            <input type="checkbox" name="agree" value="true" id="agree">--%>
<%--            <label for="agree">회원가입 약관에 동의합니다.</label>--%>
            <form:checkbox path="agree" value="true" label="회원가입 약관에 동의합니다." />
        </dd>
    </dl>
    <button type="submit">가입하기</button>
</form:form>