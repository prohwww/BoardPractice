package com.test.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		
		req.setCharacterEncoding("UTF-8");

		String search = req.getParameter("search");
		
		if(search == null || search.equals("")) {
			search = "";
		}
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("search", search);
		
		BoardDAO dao = new BoardDAO();
		
		//페이징
		int page = 0;
		int pagelist = 10;
		
		String pagenow = req.getParameter("page");
		if(pagenow == null || pagenow.equals("")) {
			pagenow = 1+"";
		}
		
		map.put("min", pagenow);
		map.put("max", (Integer.parseInt(pagenow)+10)+"");
		
		int count = dao.countPage(pagelist);
		
		
		
		
		
		ArrayList<BoardDTO> list = dao.getList(map);
		
		req.setAttribute("search", search);
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
