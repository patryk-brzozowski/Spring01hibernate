<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 07.07.2021
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty errors}" ><h2>Brak błędów</h2></c:if>
<c:forEach items="${errors}" var="error">

    <h3>${error.propertyPath} : ${error.message}</h3>

</c:forEach>

</body>
</html>
