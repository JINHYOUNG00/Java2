package com.yedam.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DataSource;

public class LibraryServiceImpl implements LibraryService {

	private DataSource dao = DataSource.getInstance();
//	private Connection conn = dao.getConnection();

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BookVO> selectAllList() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM BOOK_LIST";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery(); // rs에 쿼리결과를 받음

			while (rs.next()) {
				BookVO book = new BookVO(); // 정보를 담기위한 인스턴스 생성
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));

				list.add(book); // book에 담아둔 정보를 list에 저장
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list; // 최종적으로 list로 반환
	}

	@Override
	public BookVO selectBookInfo(String name) { // 전체조회와의 차이는 리스트에 저장하느냐 아니냐 차이.
		BookVO book = new BookVO(); // 정보를 담기위한 인스턴스 생성
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM BOOK_LIST where title = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery(); // rs에 쿼리결과를 받음

			while (rs.next()) { // if를 써도 상관없음
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book; // 최종적으로 book으로 반환
	}

	@Override
	public List<BookVO> selectBookList(String keyword) {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM BOOK_LIST WHERE CONTENT LIKE '%'||?||'%'";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, keyword);
			rs = psmt.executeQuery(); // rs에 쿼리결과를 받음

			while (rs.next()) {
				BookVO book = new BookVO(); // 정보를 담기위한 인스턴스 생성
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));

				list.add(book); // book에 담아둔 정보를 list에 저장
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
			conn = dao.getConnection();
			String sql = "SELECT * FROM BOOK_LIST where rental = 0";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery(); // rs에 쿼리결과를 받음

			while (rs.next()) {
				BookVO book = new BookVO(); // 정보를 담기위한 인스턴스 생성
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));

				list.add(book); // book에 담아둔 정보를 list에 저장
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
			// DB 새로운 연결
			conn = dao.getConnection();
			String sql = "update book_list set rental = 1 where title = ?";
			// DB에 전달할 SQL문을 만듦
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			// DB에서 실행된 SQL문의 결과를 반환
			int result = psmt.executeUpdate(); // psmt.executeQuery() 가 아님

			if (result > 0) {
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
			// DB 새로운 연결
			conn = dao.getConnection();
			String sql = "update book_list set rental = 0 where title = ?";
			// DB에 전달할 SQL문을 만듦
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			// DB에서 실행된 SQL문의 결과를 반환
			int result = psmt.executeUpdate(); // psmt.executeQuery() 가 아님

			if (result > 0) {
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

		try {
			conn = dao.getConnection();
			String sql = "INSERT INTO BOOKS VALUES(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getWriter());
			psmt.setString(3, book.getContent());
			psmt.setInt(4, book.getRental());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

}
