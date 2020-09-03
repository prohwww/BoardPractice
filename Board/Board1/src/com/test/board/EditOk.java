package com.test.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editok.do")
public class EditOk extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String seq = req.getParameter("seq");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int result = dao.update(dto);
		
		if(result == 1) {
			resp.sendRedirect("/board/view.do?seq="+seq);
		}else {
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");			
			writer.print("</body>");
			writer.print("<script>");
			writer.print("alert('edit failed'); history.back();");
			writer.print("</script>");
			writer.print("</html>");
			writer.close();
		}
		
	}
	
	
}
