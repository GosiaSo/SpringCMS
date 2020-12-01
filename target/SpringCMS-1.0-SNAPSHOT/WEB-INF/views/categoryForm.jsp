<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 18/08/2020
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post"
           modelAttribute="category">
    <form:input path="name"/>
    <form:input path="description"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
