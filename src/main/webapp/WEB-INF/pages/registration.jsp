<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 19.07.2015
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" type="text/css" href ="<c:url value="/css/reg.css"/>"/>
</head>
<body>
<div style ="margin-top: 250px;">
    <div align="center">
        <h2>Registration</h2>
<form action="registrationStatus" method="post">
        <div class="form" >
            <p><span>Login</span><input type="text" name="login"  required pattern="[a-z]+"><span></span><span></span></p>
            <p><span>Name</span><input type="text" name="name"  required pattern="[a-z]{2,}"><span></span><span></span></p>
            <p><span>Password</span><input type="password" name="password" required pattern ="(.){3,}"><span></span><span></span></p>

        </div>

    <input type="submit" value="submit" />
</form>
</div>
    </div>
</body>
</html>
