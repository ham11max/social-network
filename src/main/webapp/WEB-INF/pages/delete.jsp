<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 20.07.2015
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>delete</title>
    <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<div style ="margin-top: 210px;">
<div align="center">
<h2>Delete</h2>
<h4>You want delete user, please insert his login</h4>
    <form class="form-inline" action="del" method="post">
        <div class="form-group">
            <label class="sr-only" for="exampleInputAmount">Delete user</label>
            <div class="input-group">
                <div class="input-group-addon">User</div>
                <input type="text" name="login" class="form-control" id="exampleInputAmount" placeholder="Write login here">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Delete User</button>
    </form>

</div>
</div>
</body>
</html>
