package co.jin.test;

import java.util.Scanner;

import co.jin.test.book.Book;

public class Menu {
	static Scanner scn = new Scanner(System.in);
	private static int menu;
	
	public static void main() {
		boolean b = true;
		while (b) {
			System.out.println("================================================================================");
			System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여기능 | 5.책 대여 | 6.책 반납 | 7.책 등록| 9.종료");
			System.out.println("================================================================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				Book.bookListSelect();
			} else if (menu == 2) {
				Book.selectBook();
			} else if (menu == 3) {
				Book.contentselect();
			} else if (menu == 4) {
				
			} else if (menu == 5) {
				
			} else if (menu == 6) {
				
			} else if (menu == 7) {
				Book.addBook();
			} else if (menu == 9) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}
	}

}
