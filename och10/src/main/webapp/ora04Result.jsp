<%@page import="och10.Dept"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Dept dept= (Dept)request.getAttribute("dept");
%>
<h2>Expression 부서정보</h2>
부서코드 :<%=dept.getDeptno() %>
부서명 : <%=dept.getDname() %>
근무지 : <%=dept.getLoc() %>


</body>
</html>