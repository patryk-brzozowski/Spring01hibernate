<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${authors}" var="author">
    <h3>${author}</h3>
    <a href="/authorform/delete/${author.id}">Delete</a>
    <a href="/authorform/edit/${author.id}">Edit</a>
</c:forEach>
<br/>
<br/>
<a href="/authorform">Add new author</a>

<form method="post" action="/authorform/show/pesel">

    <label for="pesel">Find by pesel:</label>
    <input type="text" name="pesel" id="pesel">

    <input type="submit" value="Find">
</form>

<form method="post" action="/authorform/show/email">


    <label for="email">Find by email:</label>
    <input type="text" name="email" id="email">

    <input type="submit" value="Find">
</form>

<form method="post" action="/authorform/show/lastName">


    <label for="lastName">Find by last name:</label>
    <input type="text" name="lastName" id="lastName">

    <input type="submit" value="Find">
</form>


<a href="/authorform/show">Show all</a>
</body>
</html>
