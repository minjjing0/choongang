<%@page import="java.util.HashMap"%>
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
	//                  KEY        VALUE
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("park",   "목동");
			map.put("노민경",   "신촌");
			map.put("김동욱",   "홍대");
			map.put("김지훈",   "시드니");
			
			request.setAttribute("ADDRESS", map);
			RequestDispatcher dispatcher =
						request.getRequestDispatcher("mapView.jsp?NAME=김지훈");
			dispatcher.forward(request, response);
	%>
</body>
</html>