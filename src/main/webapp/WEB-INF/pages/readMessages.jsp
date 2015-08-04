<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 19.07.2015
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>

<div align="center">

  <div class="panel panel-default"align="center">
    <!-- Default panel contents -->
    <div class="panel-heading"><h2><spring:message code="label.read.top.message1"/> </h2></div>

    <!-- Table -->

    <table class="table table-hover" align="center">
      <tr>
        <td align="center">
          <font size="10"  face="Times New Roman">
            <p class="bg-success">ID</p>

          </font>
        </td>
        <td align="center">
          <font size="10"  face="Times New Roman">
            <p class="bg-success"><spring:message code="label.read.table.sender"/> </p>
          </font>

        </td>
        <td align="center">
          <font size="10"  face="Times New Roman">
            <p class="bg-success"><spring:message code="label.read.table.message"/> </p>
          </font>

      </tr>
      <c:forEach items="${messages}" var="message">
        <tr>
          <td align="center"><c:out value="${message.id}"/></td>
          <td align="center"><c:out value="${message.sender}"/></td>
          <td align="center"><c:out value="${message.message}"/></td>
        </tr>
      </c:forEach>
    </table>
  </div>
    <a class="btn btn-success" href="write" role="button"><spring:message code="label.read.button"/> </a>
</div>
</div>
</body>
</html>
