package co.jin.test.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.test.book.service.BookService;
import co.jin.test.book.service.BookVO;
import co.jin.test.book.serviceImpl.BookServiceImpl;

public class Book {
	static Scanner scn = new Scanner(System.in);
	static BookService service = new BookServiceImpl();
	static List<BookVO> list = new ArrayList<BookVO>();
	
	public static void bookListSelect() {
		list = service.bookListSelect();
		for(BookVO vo : list) {
			System.out.printf("책제목 : %s, 저자명 : %s, 내용 : %s, 대여여부 : %s \n",vo.getBookName(),vo.getWriterName(),vo.getContent(),vo.getLent());
		}
	}
	
	public static void addBook() {
		BookVO vo = new BookVO();
		System.out.println("책제목 >>");
		vo.setBookName(scn.nextLine());
		System.out.println("저자");
		vo.setWriterName(scn.nextLine());
		System.out.println("내용");
		vo.setContent(scn.nextLine());
		vo.setLent("대여가능");
		
		service.insertBook(vo);
	}
	
	public static void selectBook() {
		BookVO vo = new BookVO();
		System.out.print("책제목>");
		vo.setBookName(scn.nextLine());
		System.out.println();
		
		vo = service.selectBook(vo);
		
		System.out.printf("책제목 : %s, 저자명 : %s, 내용 : %s, 대여여부 : %s \n",vo.getBookName(),vo.getWriterName(),vo.getContent(),vo.getLent());
	}
	
	public static void contentselect() {
		BookVO vo = new BookVO();
		List<BookVO> books = new ArrayList<BookVO>();
		System.out.print("검색내용>>");
		vo.setContent(scn.nextLine());
		
		books = service.selectcontentBook(vo);
		
		System.out.printf("책제목 : %s, 저자명 : %s, 내용 : %s, 대여여부 : %s \n",vo.getBookName(),vo.getWriterName(),vo.getContent(),vo.getLent());
	}
			

}
