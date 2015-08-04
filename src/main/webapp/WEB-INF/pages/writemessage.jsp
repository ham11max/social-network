<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 21.07.2015
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<div style ="margin-top: 210px;">
  <div align="center">
    <h2>${sessionSaver.login} <spring:message code="label.write.top.message1"/> </h2>
    <h2><spring:message code="label.write.top.message2"/> </h2>
    <h4><spring:message code="label.write.top.message3" /></h4>
    <form class="form-inline" action="write" method="post">
      <div class="form-group">
        <label class="sr-only" for="exampleInputAmount"><spring:message code="label.write.button"/> </label>
        <div class="input-group">
          <div class="input-group-addon"><spring:message code="label.logdel.form.message1"/> </div>
          <input type="text" name="receiver" class="form-control" id="exampleInputAmount" placeholder="<spring:message code="label.logdel.form.message2"/>">
        </div>
      </div>
      <textarea class="form-control" name="message" rows="10"></textarea>
      <button type="submit" class="btn btn-primary"><spring:message code="label.write.button"/> </button>
    </form>

  </div>
</div>

</body>
</html>
