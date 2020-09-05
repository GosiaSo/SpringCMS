<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: malgorzatasobocinska
  Date: 18/08/2020
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Czy na pewno chcesz usunąć autora?</h4>
<a href='<c:url value="/author/remove/${author.getId()}"/>'>TAK, USUŃ</a>
<br>
<a href='<c:url value="/authorList"/>'>NIE, COFNIJ</a>
</body>
</html>