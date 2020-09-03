package com.test.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete.do")
public class Delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.delete(seq);
		
		if(result == 1) {
			resp.sendRedirect("/board/boardlist.do");
		}else {
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("</body>");
			writer.print("<script>");
			writer.print("alert('delete failed'); history.back();");
			writer.print("</script>");
			writer.print("</html>");
			writer.close();
		}
		
	}
	
}
