package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.reqNresp.requestTest02;
import kr.or.ddit.vo.lprodVO;

@WebServlet("/lprodList.do")
public class lprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		lprodService service = lprodService.getLprodService();
		
		List<lprodVO> lprodlist = service.getLprod();
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(lprodlist);
		
		response.getWriter().write(jsonData);
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		/*
		  String lprod = request.getParameter("lprodlist");
		  
		  lprodService service = lprodService.getLprodService();
		  
		  List<lprodVO> vo = service.getLprod();
		  
		  request.setAttribute("lp", vo);
		  
		  request.getRequestDispatcher("/view/lprodview.jsp").forward(request,
		  response);
		  
		  
		 */
	}

}
