package com.yedam.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DataSource;

public class LibraryServiceImpl implements LibraryService {
	
	private DataSource dao = DataSource.getInstance();  // 
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// conn을 끊는 메서드  연결은 끊어주는게 자원활용에 좋음.
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BookVO> selectAllList() {
		// 전체조회
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM BOOK_LIST";
			psmt = conn.prepareStatement(sql);  // sql문을 DB에 전송하여 쿼리문을 진행함.
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			while(rs.next()) {  // 하나씩 읽어서 리스트에 담음.
				BookVO book = new BookVO();
				book.setTitle(rs.getString("TITLE"));
				book.setWriter(rs.getString("WRITER"));
				book.setContent(rs.getString("CONTENT"));
				book.setRental(rs.getInt("RENTAL"));
				list.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		
		
		return list;
	}

	@Override
	public BookVO selectBookInfo(String name) {
		BookVO book = new BookVO();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM BOOK_LIST WHERE TITLE = ?";
			psmt = conn.prepareStatement(sql);  // sql문을 DB에 전송하여 쿼리문을 진행함.
			psmt.setString(1, name);  // ? 값채우기
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			if(rs.next()) {  // 하나씩 읽어서 리스트에 담음.
				book.setTitle(rs.getString("TITLE"));
				book.setWriter(rs.getString("WRITER"));
				book.setContent(rs.getString("CONTENT"));
				book.setRental(rs.getInt("RENTAL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return book;

	}

	@Override
	public List<BookVO> selectBookList(String keyword) {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM BOOK_LIST WHERE CONTENT LIKE '%'||?||'%'";
			psmt = conn.prepareStatement(sql);  // sql문을 DB에 전송하여 쿼리문을 진행함.
			psmt.setString(1, keyword); // ?채우기
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			while(rs.next()) {  // 하나씩 읽어서 리스트에 담음.
				BookVO book = new BookVO();
				book.setTitle(rs.getString("TITLE"));
				book.setWriter(rs.getString("WRITER"));
				book.setContent(rs.getString("CONTENT"));
				book.setRental(rs.getInt("RENTAL"));
				list.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		
		
		return list;
	}

	@Override
	public List<BookVO> selectRentalBookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection(); // connection을 가져옴.
			String sql = "SELECT * FROM BOOK_LIST WHERE RENTAL = 0";
			psmt = conn.prepareStatement(sql);  // sql문을 DB에 전송하여 쿼리문을 진행함.
			rs = psmt.executeQuery(); // 결과를 rs(result Set)에 받음.
			while(rs.next()) {  // 하나씩 읽어서 리스트에 담음.
				BookVO book = new BookVO();
				book.setTitle(rs.getString("TITLE"));
				book.setWriter(rs.getString("WRITER"));
				book.setContent(rs.getString("CONTENT"));
				book.setRental(rs.getInt("RENTAL"));
				list.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public void rentalBook(String name) {
		try {
			conn = dao.getConnection(); // DB에 연결통로를 만듦.
			String sql = "UPDATE BOOK_LIST SET RENTAL = 1 WHERE TITLE = ?";
			psmt = conn.prepareStatement(sql);  // DB에 sql문을 전달
			psmt.setString(1, name);
			int result = psmt.executeUpdate(); // SQL문의 결과를 받음.
			
			if(result > 0) {
				System.out.println("해당 책이 정상적으로 대여되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	@Override
	public void returnBook(String name) {
		try {
			conn = dao.getConnection(); // DB에 연결통로를 만듦.
			String sql = "UPDATE BOOK_LIST SET RENTAL = 0 WHERE TITLE = ?";
			psmt = conn.prepareStatement(sql);  // DB에 sql문을 전달
			psmt.setString(1, name);
			int result = psmt.executeUpdate(); // SQL문의 결과를 받음.
			
			if(result > 0) {
				System.out.println("해당 책이 정상적으로 반납되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void insertBook(BookVO book) {
		// TODO Auto-generated method stub
		// 책등록
		
		String sql = "INSERT INTO BOOK_LIST VALUES(?,?,?,?)";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getWriter());
			psmt.setString(3, book.getContent());
			psmt.setInt(4, book.getRental());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}