<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--스크립틀릿-->
<%
 request.setCharacterEncoding("utf-8");
 String title = request.getParameter("title");
 String writer = request.getParameter("writer");
 String content = request.getParameter("content");
//Current Date
 Date date = new Date();
//파일저장
long fileName= date.getTime();
//getRealPath -->Tomcat Metadata File 저장
String real = application.getRealPath("/WEB-INF/out/"+fileName+".txt");
System.out.println(real);
//파일 저장할 수 있는 객체
FileWriter fw = new FileWriter(real);
// 파일 내용 
//"\r\n : 줄바꿈 , return lin
String msg = "제목: "+title +"\r\n"; 
msg+= "작성자:"+writer+"\r\n";
msg+= "내용"+content+"\r\n";
fw.write(msg);
fw.close();
 //화면 출력
 out.println("제목1:" +title+"<p>");
 out.println("작성자1:" +writer+"<p>");
 out.println("내용1:" +content+"<p>");
 
 
%>

<!-- 화면출력 -->
<h1> 제목 : <%=title %><br></h1>
작성자 : <%= writer %><br>
내용 : <%=content %>
</body>
</html>