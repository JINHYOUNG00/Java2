package co.micol.notice;

import java.util.Scanner;

import co.micol.notice.service.NoticeService;
import co.micol.notice.serviceImpl.NoticeServiceImpl;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class Menu {

	private Scanner scn = new Scanner(System.in);
private void mainmenu() {
	while(true)
	{
		System.out.println("=======================================");
		System.out.println("1.학생관리 2.공지사항 3.종료");
		System.out.println("=======================================");
		System.out.println("원하는 작업을 선택하세요");
		int menu = scn.nextInt();
		scn.nextLine();

		if (menu == 1) {
			

		} else if (menu == 2) {

		} else if (menu == 3) {
			break;
			System.out.println("종료합니다.");
		}
	}
}

}
