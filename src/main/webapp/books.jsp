<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 06.07.2021
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${books}" var="book">
    <h4>${book}</h4>
    <a href="/bookform/delete/${book.id}">Delete</a>
    <a href="/bookform/edit/${book.id}">Edit</a>
</c:forEach>
<br/>
<br/>
<a href="/bookform">Add new book</a>
<br/>
<br/>
<form method="post" action="/bookform/show/rating">

    <label for="rating">Find by rating:</label>
    <select  name="rating" id="rating" >
    <c:forEach items="${ratings}" var="rating">
        <option value="${rating}">${rating}</option>
    </c:forEach>
    </select>
    <input type="submit" value="Find">
</form>

<form method="post" action="/bookform/show/publisher">

    <label for="publisher">Find by publisher:</label>
    <select  name="id" id="publisher" >
        <c:forEach items="${publishers}" var="publisher">
            <option value="${publisher.id}">${publisher.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Find">
</form>

<form method="post" action="/bookform/show/category">

    <label for="category">Find first by category:</label>
    <select  name="id" id="category" >
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Find">
</form>
</body>
</html>
