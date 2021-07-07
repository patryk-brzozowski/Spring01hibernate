<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 06.07.2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="student">
    <label for="firstName">First name:</label>
    <form:input path="firstName" id="firstName"/> <br/>
    <label for="lastName">Last name:</label>
    <form:input path="lastName" id="lastName"/> <br/>
    <label for="gender">Gender:</label>
    <form:radiobuttons path="gender" id="gender" items="${genders}"/> <br/>
    <label for="country">Country:</label>
    <form:select path="country" items="${countries}" /> <br/>
    <label for="notes">Notes:</label>
    <form:textarea path="notes"/> <br/>
    <label for="mailingList">Add to mailing list:</label>
    <form:checkbox path="mailingList" id="mailingList"/> <br/>
    <label for="programmingSkills">Skills:</label>
    <form:select path="programmingSkills" items="${skills}" multiple="true"/> <br/>
    <label for="hobbies">Hobbies:</label>
    <form:checkboxes path="hobbies" items="${hobbies}"/> <br/>

    <input type="submit"/>
</form:form>

</body>
</html>
