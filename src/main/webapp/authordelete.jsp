<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 14:16
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
  <input type="hidden" name="id" value="${author.id}"/>
  <input type="submit" value="Confirm">
</form>
<a href="/authorform/show">Cancel</a>
</body>
</html>
