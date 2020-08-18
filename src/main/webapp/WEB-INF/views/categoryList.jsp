<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 18/08/2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href='<c:url value="/addCategory"/>'>DODAJ KATEGORIĘ </a>
<table>
    <thead>
    <tr>
        <th> NAME</th>
        <th> DESCRIPTION</th>

    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td> <a href='<c:url value="/category/edit/${category.getId()}"/>'>Edit</a> </td>
            <td> <a href='<c:url value="/category/confirm/${category.getId()}"/>'>Delete</a> </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
