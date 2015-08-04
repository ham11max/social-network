<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 18.07.2015
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
  <title>success</title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>

</head>
<body>

<div style ="margin-top: 250px;">
  <div align="center">
    <h2><spring:message code="label.auth.top.message1"/> </h2>
    <h4><spring:message code="label.auth.top.message2"/> ${sessionSaver.login} </h4>

    <br>
    <a class="btn btn-primary" href="users" role="button"><spring:message code="label.auth.button1"/> </a>
    </br>
    <br>
    <a class="btn btn-primary" href="write" role="button"><spring:message code="label.auth.button2"/> </a>
    </br>
      <br>
      <a class="btn btn-primary" href="read" role="button"><spring:message code="label.auth.button3"/> </a>
      </br>
    <br>
    <br>
    <a class="btn btn-danger" href="exit" role="button"><spring:message code="label.auth.button4"/> </a>


    </div>
  </div>

</body>
</html>
