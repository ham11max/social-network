<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 18.07.2015
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>

<div style ="margin-top: 210px;">
  <div align="center">
<h2>Login</h2>

    <form action="auth" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Login</label>
        <input type="text" name="login" class="form-control" id="exampleInputEmail1" placeholder="Login">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>

</div>
  </div>
</body>
</html>
