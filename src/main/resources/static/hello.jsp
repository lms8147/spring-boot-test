<%--
  Created by IntelliJ IDEA.
  User: lms81
  Date: 2018-07-31
  Time: 오후 6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>servlet test</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL();

    out.print("url : " + url.toString());
    out.print("<br>");
%>
</body>
</html>
