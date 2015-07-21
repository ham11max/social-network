<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 18.07.2015
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>success</title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>

</head>
<body>

<div style ="margin-top: 250px;">
  <div align="center">
    <h2>Login success</h2>
    <h4>Hi ${login} </h4>
    <br>
    <a class="btn btn-primary" href="users" role="button">Get all users</a>
</br>
    </div>
  </div>

</body>
</html>
