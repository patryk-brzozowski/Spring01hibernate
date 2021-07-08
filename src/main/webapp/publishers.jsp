<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${publishers}" var="publisher">
    <h3>${publisher}</h3>
    <a href="/publisherform/delete/${publisher.id}">Delete</a>
    <a href="/publisherform/edit/${publisher.id}">Edit</a>
</c:forEach>
<br/>
<br/>
<a href="/publisherform">Add new publisher</a>

<form method="post" action="/publisherform/show/nip">

    <label for="nip">Find by nip:</label>
    <input type="text" name="nip" id="nip">

    <input type="submit" value="Find">
</form>

<form method="post" action="/publisherform/show/regon">


    <label for="regon">Find by regon:</label>
    <input type="text" name="regon" id="regon">

    <input type="submit" value="Find">
</form>

<a href="/publisherform/show">Show all</a>
</body>
</html>
