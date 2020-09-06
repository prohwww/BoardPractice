package com.test.board;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		DBUtil util = new DBUtil();
		conn = util.open();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Board 서블릿 -> 글 목록 가져오기
	public ArrayList<BoardDTO> getList(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			if(map.get("search") != null || !map.get("search").equals("")) {
				
				where = String.format("where title like '%%%s%%' or content like '%%%s%%'",map.get("search"),map.get("search"));
			}
			
			String sql = String.format("select * from tblBoard %s order by seq desc",where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				
				String date = rs.getString("regdate");
				String[] arr = date.split(" ");
				
				dto.setRegdate(arr[0]);
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//WriteOk -> 글쓰기
	public int write(BoardDTO dto) {
		try {
			String sql = "insert into tblBoard (seq,title,content,regdate) values (seqBoard.nextVal, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//View -> 글 불러오기
	public BoardDTO getLog(String seq) {
		
		try {
			String sql = "select * from tblBoard where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			BoardDTO dto = new BoardDTO();
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//EditOk
	public int update(BoardDTO dto) {
		try {
			String sql = "update tblBoard set title=?, content=? where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//Delete
	public int delete(String seq) {
		try {
			String sql = "delete from tblBoard where seq=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//Board
	public int countPage(int pagelist) {
		try {
			String sql = "select count(*) as cnt from tblBoard";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
