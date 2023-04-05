package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class sessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		//저장된 Session 정보 읽어오기
		HttpSession session = request.getSession();
		
	
		if("admin".equals(userId) && "1234".equals(userPass)) { //로그인 성공
			session.setAttribute("LOGINID", userId); //세션값 저장 (키값 : 저장할데이터)
			out.println("<h2>"+ userId+ "님 반갑습니다.</h2><br><br>");
			
		} 
		
		//sessionLogin.jsp로 이동하기
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp" );
		
		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body>");
		
		
		out.println("<a href='" + request.getContextPath() + "/basic/session/sessionLogin.jsp'>로그아웃</a>");
		
		out.println("</body></html>");
		}

		
	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
