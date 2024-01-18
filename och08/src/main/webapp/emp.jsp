<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--java Bean 선언  -->
<jsp:useBean id="emp" class="och08.Emp" scope="request"></jsp:useBean>
<!--Bean 값 저장  -->

<jsp:setProperty property="*" name="emp"/><p> 




<!--Bean page 이동  -->
<jsp:forward page="empResult.jsp"></jsp:forward>
</body>
</html>