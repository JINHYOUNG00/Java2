package com.yedam.java.service;

import java.util.List;

public interface LibraryService {
	//전체조회
	List<BookVO> selectAllList();         // 전체반환이기때문에 리스트로 반환 
	//한건조회
	BookVO selectBookInfo(String name);
	//내용조회
	List<BookVO> selectBookList(String keyword);
	//대여가능조회
	List<BookVO> selectRentalBookList();
	//대여
	void rentalBook(String name);
	//반납
	void returnBook(String name);
	//등록
	void insertBook(BookVO book);
}
