package och01;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Add3
 */
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super(); //아버지, 부모 => HttpServlet 
        // TODO Auto-generated constructor stub
    } // 기본생성자 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Add3 Get Start");
		int num = Integer.parseInt(request.getParameter("num")); 
		String loc = request.getParameter("loc");
		System.out.println("Add3 num"+ num);
		int sum =0;
		for ( int i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.println("Add3 sum=>"+sum);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//공식 --> 사용자 Browser에 보여주는 객체 
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계 %s</h1>",num,loc);
//		out.printf("<h4>LOC-->%s<h4>" ,loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("Add3 Post Start");
		// 목표 :  1부터 누적값 전달 
		
	}

}
