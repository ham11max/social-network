<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 18.07.2015
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login page</title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>

<div style ="margin-top: 210px;">
  <div align="center">
<h2><spring:message code="label.log.top.message"/> </h2>

    <form action="auth" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1"><spring:message code="label.users.table.login"/> </label>
        <input type="text" name="login" class="form-control" id="exampleInputEmail1" placeholder="<spring:message code="label.users.table.login"/>">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1"><spring:message code="label.password"/> </label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="<spring:message code="label.password"/> ">
      </div>
      <button type="submit" class="btn btn-default"><spring:message code="label.submit"/> </button>
    </form>

</div>
  </div>
</body>
</html>
