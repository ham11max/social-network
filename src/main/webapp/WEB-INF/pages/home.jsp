<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 18.07.2015
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>Social</title>
    <link rel="stylesheet" type="text/css" href ="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<span style="float: right">
    <a href="?lang=en"><img src="http://ukrexport.gov.ua/i/imgsupload/UKflag.JPG" height="20" width="30"/></a>
    <a href="?lang=ua"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/1024px-Flag_of_Ukraine.svg.png" height="20" width="30" /></a>
</span>
<div style ="margin-top: 210px;">
<div align="center">
    <font size="20"  face="Times New Roman">
        <p class="bg-primary"><spring:message code = "label.main.top.message1"/></p>

    </font>
    <br>
    <spring:message code = "label.main.top.message2"/>
    </br>
    <br>
    <a href="log" class="btn btn-primary btn-lg active" role="button"><spring:message code="label.button1" /></a>
    </br>
<br>
    <spring:message code = "label.main.top.message3"/>
</br>

    <br>
        <a href="reg" class="btn btn-primary btn-lg active" role="button"><spring:message code="label.button2"/> </a>
    </br>
</div>
</div>
</body>
</html>
