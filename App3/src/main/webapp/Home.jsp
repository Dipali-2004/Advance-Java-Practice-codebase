
<%@ page import="com.dipali.pack.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
   UserBean ub = (UserBean) application.getAttribute("userBean");
   out.println("Welcome "+ub.getU_fname()+"<br><br>");
%>
<a href="view">View Profile</a>
<a href="Layout">Logout</a>
</h1>
</center>


</body>
</html>