<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 19.07.2015
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>

  <div align="center">

<div class="panel panel-default"align="center">
  <!-- Default panel contents -->
  <div class="panel-heading"><h2>Users list</h2></div>

  <!-- Table -->

  <table class="table table-bordered" align="center">
    <th>ID</th>
    <th>Name</th>
    <th>Login</th>
    <th>Password</th>
    <c:forEach items="${user}" var="user">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.pass}"/></td>
      </tr>
    </c:forEach>
  </table>
</div>
      <a class="btn btn-success" href="logdel" role="button">Delete User</a>
  </div>
</div>
</body>
</html>
