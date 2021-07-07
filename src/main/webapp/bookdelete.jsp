<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 06.07.2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H2>Are you sure?</H2>
<form method="post">
    <input type="hidden" name="id" value="${book.id}"/>
    <input type="submit" value="Confirm">
</form>
<a href="/bookform/show">Cancel</a>
</body>
</html>
