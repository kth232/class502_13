<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="actionUrl" value="/file/upload" />
<form method="post" action="${actionUrl}" enctype="multipart/form-data">
    <!--파일 전송을 위해 멀티 파트임을 명시해야 함(요청 헤더 content-type 값 바뀜)-->
    title: <input type="text" name="subject"><br>
    content: <input type="text" name="content"><br>
    file: <input type="file" name="file"><br>
    <!--파일탐색기를 통해 파일 업로드-->
    <button type="submit">SUBMIT</button>
</form>