<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 19/08/2020
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post"
           modelAttribute="article">
    <form:input path="title"/>
    <form:select path="author" items="${authors}" itemLabel="lastName" itemValue="id"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
