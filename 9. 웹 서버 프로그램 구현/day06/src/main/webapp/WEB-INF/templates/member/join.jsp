<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/member/join" />

<layout:main title="join">
    <h1>JOIN</h1>
    <form method="post" action="${acitonUrl}" autocomplete="off" target="ifrmProcess">
    <%--form 태그로 감싸야만 데이터 전송 가능, 자동완성 기능 끄기, 히든 프레임으로 제출--%>
    <dl>
        <dt>email</dt>
        <dd>
            <input type="text" name="email">
        </dd>
    </dl>
    <dl>
        <dt>password</dt>
        <dd>
            <input type="password" name="password">
        </dd>
    </dl>
    <dl>
        <dt>confirm password</dt>
        <dd>
            <input type="password" name="confirmPassword">
        </dd>
    </dl>
    <dl>
        <dt>user name</dt>
        <dd>
            <input type="text" name="userName">
        </dd>
    </dl>
    <div>
        <input type="checkbox" name="termsAgree" value="true" id="termsAgree">
        <label for="termsAgree">Agree JOIN TERMS</label>
    </div>
        <button type="submit">JOIN</button>
    </form>
</layout:main>
<%--뷰 역할-회원가입 양식--%>