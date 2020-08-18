<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 18/08/2020
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<a href='<c:url value="/addAuthor"/>'>DODAJ AUTORA </a>
<table>
    <thead>
    <tr>
        <th> FIRST NAME</th>
        <th> LAST NAME</th>

    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.Lastname}</td>
            <td> <a href='<c:url value="/author/edit/${author.getId()}"/>'>Edit</a> </td>
            <td> <a href='<c:url value="/author/confirm/${author.getId()}"/>'>Delete</a> </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
