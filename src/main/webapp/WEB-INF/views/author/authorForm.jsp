<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 18/08/2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post"
           modelAttribute="author">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
