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
	  String[] col={"red","orange","yellow","green","blue","navy","violet","black"};
	//n은 8미만 숫자  
	  int n= (int)(Math.random()*8);
	//color1.jsp gugu1.jsp response.jsp  
	String pgm = request.getParameter("pgm")+".jsp";
	/* form 문을 통하지 않고 페이지를 이동할 수 있는 방법 -> 1. RequestDispatcher */
	  RequestDispatcher rd = request.getRequestDispatcher(pgm);
	  if(pgm.equals("color1.jsp")){
		  //변수선언
		  /* setAttribute가 form문을 통하지 않고 파라미터를 넘겨줄 수 있음 */
		  request.setAttribute("color",col[n]);
		  //rd= request.getRequestDispatcher("color1.jsp")
	  } else if (pgm.equals("gugu1.jsp")){
		  //2~9단
		  request.setAttribute("num", n+2);
		  //rd = request.getReqeustDispatcher("gugu1.jsp");
	  } else if(pgm.equals("response.jsp")){
		  
	  }
	  
	  //2.이동 page를 지정하는 객체 선언을 실제적으로 이동  
	  rd.forward(request,response);
%>

</body>
</html>