package co.jin.test.book.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jin.test.book.service.BookService;
import co.jin.test.book.service.BookVO;
import co.jin.test.dao.DataSource;

public class BookServiceImpl implements BookService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	BookVO vo = new BookVO();

	@Override
	public List<BookVO> bookListSelect() {
		List<BookVO> books = new ArrayList<BookVO>();
		BookVO book;
		String sql = "SELECT * FROM BOOKS";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				book = new BookVO();
				book.setBookName(rs.getString("BOOK_NAME"));
				book.setWriterName(rs.getString("WRITER_NAME"));
				book.setContent(rs.getString("CONTENT"));
				book.setLent(rs.getString("LENT"));
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return books;
	}

	@Override
	public BookVO selectBook(BookVO book) {
		String sql = "Select * from books where book_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo = new BookVO();
				vo.setBookName(rs.getString("book_name"));
				vo.setWriterName(rs.getString("writer_name"));
				vo.setContent(rs.getString("content"));
				vo.setLent(rs.getString("lent"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return vo;
	}

	@Override
	public List<BookVO> selectcontentBook(BookVO book) {
		List<BookVO> books = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOKS WHERE CONTENT LIKE '%'||?||'%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getContent());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo = new BookVO();
				vo.setBookName(rs.getString("book_name"));
				vo.setWriterName(rs.getString("writer_name"));
				vo.setContent(rs.getString("content"));
				vo.setLent(rs.getString("lent"));
				
				books.add(book);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return books;
	}

	@Override
	public int insertBook(BookVO book) { // 책 등록
		int n = 0;
		String sql = "insert into books values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			psmt.setString(2, book.getWriterName());
			psmt.setString(3, book.getContent());
			psmt.setString(4, book.getLent());
			n= psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateBook(BookVO book) {
		
		return 0;
	}

	@Override
	public int deleteBook(BookVO book) {
		
		return 0;
	}

	@Override
	public List<BookVO> bookListSelect1() {
		// TODO Auto-generated method stub
		return null;
	}

}
