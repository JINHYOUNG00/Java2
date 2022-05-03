package co.micol.notice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.serviceImpl.NoticeServiceImpl;

public class Notice {
	Scanner scn = new Scanner(System.in);
	public void noticeSelectList() {
		NoticeService notice = new NoticeServiceImpl();
    	List<NoticeVO> list = new ArrayList<NoticeVO>();
    	list = notice.noticeSelectList();
    	
    	for(NoticeVO vo : list) {
    		vo.toString();
    	}
	}
	public void noticeSelect() {
		NoticeService notice = new NoticeServiceImpl();
    	NoticeVO vo = new NoticeVO();
    	System.out.println("조회할 글번호 >>");
    	int id = scn.nextInt();
    	scn.nextLine();
    	vo.setId(id);
    	vo = notice.noticeSelect(vo);
    	vo.toString();
			}
	
	public void noticeInsert() {
		NoticeVO vo = new NoticeVO();
		System.out.println("작성자 >>");
		String writer = scn.nextLine();
		System.out.println("글제목 >>");
		String title = scn.nextLine();
		System.out.println("내용");
		String subject = scn.nextLine();
		
		
	}
	public void noticeUpdate() {
		NoticeVO vo = new NoticeVO();
		System.out.println("수정할 글번호 >>");
		int id = scn.nextInt();
		scn.nextLine();
		
		
		
		
	}
	public void noticeDelete() {
		
	}
}
