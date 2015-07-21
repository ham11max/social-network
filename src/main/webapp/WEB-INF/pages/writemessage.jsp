<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 21.07.2015
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>write</title>
  <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<div style ="margin-top: 210px;">
  <div align="center">
    <h2>Send message</h2>
    <h4>Please write receiver login</h4>
    <form class="form-inline" action="write" method="post">
      <div class="form-group">
        <label class="sr-only" for="exampleInputAmount">Send message</label>
        <div class="input-group">
          <div class="input-group-addon">User</div>
          <input type="text" name="login" class="form-control" id="exampleInputAmount" placeholder="Write login here">
        </div>
      </div>
      <textarea class="form-control" name="message" rows="10"></textarea>
      <button type="submit" class="btn btn-primary">Send</button>
    </form>

  </div>
</div>

</body>
</html>
