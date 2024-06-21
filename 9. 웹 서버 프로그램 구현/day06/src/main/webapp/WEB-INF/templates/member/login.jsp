<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/member/login" />

<layout:main title="login">
    <h1>LOGIN</h1>
        <form method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dt>email</dt>
                <dd>
                    <input type="text" name="email" value="${cookie.saveEmail == null ? '' : cookie.saveEmail.value}">
                    <!--cookie.saveEmail.getValue()->value로 가능/단, 값이 없을 때 오류 발생->공백으로 처리-->
                </dd>
            </dl>
            <dl>
                <dt>password</dt>
                <dd>
                    <input type="password" name="password">
                </dd>
            </dl>
            <div>
                <input type="checkbox" name="saveEmail" value="true" id="saveEmail" ${cookie.saveEmail == null ? '' : ' checked'}>
                <!--기본으로 체크되어있는 상태-->
                <label for="saveEmail">save Email</label>
            </div>
            <button type="submit">LOGIN</button>
        </form>
</layout:main>
<%--뷰 역할-로그인 양식--%>