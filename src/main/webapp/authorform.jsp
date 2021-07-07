<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 13:55
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
<form:form method="post" modelAttribute="author">

    <label for="email">Email:</label>
    <form:input type="email" path="email"/>  <form:errors path="email"/>
    <label for="firstName">First name:</label>
    <form:input path="firstName"/>  <form:errors path="firstName"/>
    <label for="lastName">Last name:</label>
    <form:input path="lastName"/>  <form:errors path="lastName"/>
    <label for="pesel">Pesel:</label>
    <form:input path="pesel"/>   <form:errors path="pesel"/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
