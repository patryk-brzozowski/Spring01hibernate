<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3>${book}</h3>
    <a href="/bookform/delete/${book.id}">Delete</a>
    <a href="/bookform/edit/${book.id}">Edit</a>
</c:forEach>
<br/>
<br/>
<a href="/bookform">Add new book</a>

</body>
</html>
