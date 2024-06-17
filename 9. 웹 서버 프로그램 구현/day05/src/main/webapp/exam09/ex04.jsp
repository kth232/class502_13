<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<util:max num1="100" num2="200" />
${maximum}
<%--태그 끝나고 값 접근, tag 파일에서 지정한 변수명 알고 있어야 함--%>
