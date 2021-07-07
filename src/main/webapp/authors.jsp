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
</body>
</html>
