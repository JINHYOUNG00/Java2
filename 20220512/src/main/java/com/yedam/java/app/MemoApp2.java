package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.service.MemoService;
import com.yedam.java.service.MemoServiceImpl;
import com.yedam.java.service.MemoVO;

public class MemoApp2 {

	private Scanner scanner = new Scanner(System.in);
	private MemoService dao = new MemoServiceImpl();

	public void Memo() {
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				insertMemoInfo();
			} else if (menuNo == 2) {
				updateMemo();
			} else if (menuNo == 3) {
				deleteMemo();
			} else if (menuNo == 4) {
				selectMemoInfo();
			} else if (menuNo == 5) {
				selectMemoList();
			} else if (menuNo == 9) {
				end();
				break;
			}

		}
	}

	private void menuPrint() {
		System.out.println("============================================================================");
		System.out.println("1.등록 2.수정 3.삭제 4.메모조회 5.전체조회 9.종료");
		System.out.println("============================================================================");
		System.out.print("선택>");
	}

	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}

	private void selectMemoList() {   // 전체조회
		List<MemoVO> list = dao.selectAllList();
		for (MemoVO memo : list) {
			System.out.println(memo);
		}
	}

	private void selectMemoInfo() {  // 한건조회
		int num = inputNum();
		MemoVO memo = dao.selectMemoInfo(num);
		if (num == 0) {
			System.out.println("메모는 등록되어 있지 않습니다.");
		} else {
			System.out.println(memo);
		}
	}

	private void insertMemoInfo() {   // 등록
		MemoVO memo = inputMemoInfo();
		dao.insertMemo(memo);
		System.out.println("한건이 등록되었습니다.");
	}
	
	private void deleteMemo() {
		MemoVO memo = new MemoVO();
		int num = inputNum();
		memo.setNum(num);
		dao.deleteMemo(memo);
		System.out.println("한건이 삭제되었습니다.");
	}
	
	private void updateMemo() {
		MemoVO memo = new MemoVO();
		
		int num = inputNum();
		memo.setNum(num);
		System.out.println("메모내용>>");
		String name = scanner.nextLine();
		memo.setContent(name);
		dao.updateMemo(memo);
		System.out.println("한건이 수정되었습니다.");
		
		
	}
	
	
	
	
	
	

	private void end() {
		System.out.println("프로그램이 종료되었습니다.");
	}

	private int inputNum() {
		int num = 0;
		System.out.print("메모번호>");
		num = scanner.nextInt();
		scanner.nextLine();
		return num;
	}

	private String inputBookKeyword() {
		String keyword = null;
		System.out.print("검색내용>");
		keyword = scanner.nextLine();
		return keyword;
	}

	private MemoVO inputMemoInfo() {
		
		MemoVO memo = new MemoVO();
		System.out.print("메모번호>");
		memo.setNum(scanner.nextInt());
		scanner.nextLine();
		System.out.print("메모제목>");
		memo.setTitle(scanner.nextLine());
		System.out.print("메모작성자>");
		memo.setWriter(scanner.nextLine());
		System.out.print("메모내용>");
		memo.setContent(scanner.nextLine());
		return memo;
	}
}