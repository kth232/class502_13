<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h1>회원가입</h1>
<form method="post" action="${action}">
    <dl>
        <dt>email</dt>
        <dd><input type="text" name="email"></dd>
    </dl>
    <dl>
        <dt>password</dt>
        <dd><input type="text" name="password"></dd>
    </dl>
    <dl>
        <dt>confirm password</dt>
        <dd><input type="text" name="confirPassword"></dd>
    </dl>
    <dl>
        <dt>name</dt>
        <dd><input type="text" name="name"></dd>
    </dl>
    <input type="checkbox" name="termsAgree" value="true">
    <label for="terms-agree">agree terms</label>
    <br>
    <button type="submit">submit</button>
</form>
<%--${message}--%>