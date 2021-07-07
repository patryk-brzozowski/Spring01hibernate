<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">

    <label for="name">Name:</label>
    <form:input path="name"/>  <form:errors path="name"/>
    <label for="nip">Nip:</label>
    <form:input path="nip"/>  <form:errors path="nip"/>
    <label for="regon">Regon:</label>
    <form:input path="regon"/>  <form:errors path="regon"/>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
