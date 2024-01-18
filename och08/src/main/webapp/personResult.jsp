<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="och08.person" scope="request"></jsp:useBean>
	<h2>인적사항</h2>
	이름 : <jsp:getProperty property="name" name="person"/>
	성별 : <jsp:getProperty property="gender" name="person"/>
	나이 : <jsp:getProperty property="age" name="person"/>
</body>
</html>