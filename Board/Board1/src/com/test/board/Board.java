package com.test.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardlist.do")
public class Board extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.getList();
		
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
