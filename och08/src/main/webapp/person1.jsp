<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--Bean 선언  -->
	<jsp:useBean id="person" class="och08.person" scope="request"></jsp:useBean>
<!-- 값 저장 -->	
	<jsp:setProperty property="*" name="person"/>

<!--값 가져오기   -->	
	<jsp:getProperty property="name" name="person"/>
	<jsp:getProperty property="gender" name="person"/>
	<jsp:getProperty property="age" name="person"/>

</body>
</html>