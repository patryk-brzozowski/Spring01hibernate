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
    <a href="/authorform/delete/${publisher.id}">Delete</a>
    <a href="/authorform/edit/${publisher.id}">Edit</a>
</c:forEach>
</body>
</html>
