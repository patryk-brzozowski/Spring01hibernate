<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 06.07.2021
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <label for="login">Wpisz login</label>
    <form:input path="login" id="login" type="text"/>
    <label for="password">Wpisz hasło</label>
    <form:input path="password" id="password" type="text"/>
    <label for="email">Wpisz email</label>
    <form:input path="email" id="email" type="text"/>
    <input type="submit"/>
</form:form>
</body>
</html>
