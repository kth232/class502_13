<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:url var="errorUrl" value="/images/404.jpg" />
<h1>error 발생</h1>
<img src="${errorUrl}" alt="errorImg" width="800px"/>