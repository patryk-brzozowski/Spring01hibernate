<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 06.07.2021
  Time: 16:46
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
<form:form method="post" modelAttribute="book">

    <label for="title">Title:</label>
    <form:input path="title"/>  <form:errors path="title"/>
    <label for="description">Description:</label>
    <form:input path="description"/>  <form:errors path="description"/>
    <label for="category">Category:</label>
    <form:select path="category" items="${categories}" itemLabel="name" itemValue="id"/>  <form:errors path="category"/>
    <label for="pages">Pages:</label>
    <form:input type="number" path="pages"/>  <form:errors path="pages"/>
    <label for="rating">Rating:</label>
    <form:select path="rating" items="${ratings}"/>   <form:errors path="rating"/>
    <label for="authors">Authors:</label>
    <form:select path="authors" itemLabel="lastName" itemValue="id" items="${authors}" multiple="true"/>  <form:errors path="authors"/>
    <label for="publisher">Publisher:</label>
    <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>  <form:errors path="publisher"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
