package co.jin.test.book.service;

import java.util.List;

public interface BookService {
	List<BookVO> bookListSelect(); // 1.전체 조회
	BookVO selectBook(BookVO book);  // 2.단권 조회
	List<BookVO> selectcontentBook(BookVO book);  // 3.내용 조회
	int insertBook(BookVO book); //7.책 등록
	
	
	int updateBook(BookVO book); //한명 갱신
	int deleteBook(BookVO book); //한권 삭제
	List<BookVO> bookListSelect1();
	
	
	

}
