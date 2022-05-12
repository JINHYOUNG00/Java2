package com.yedam.java.service;

import lombok.Data;

@Data
public class MemoVO {
	
	private int num;
	private String title;
	private String writer;
	private String content;
	
	
	@Override
	public String toString() {
		return "메모번호 : " + num 
				+ ", 메모제목 : " +  title
				+ ", 메모 작성자 : " + writer 
				+ ", 메모 내용 : " + content ;  
	}

}
