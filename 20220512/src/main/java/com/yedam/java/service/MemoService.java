package com.yedam.java.service;

import java.util.List;

public interface MemoService {
	
	void insertMemo(MemoVO memo);// 등록
	void updateMemo(MemoVO memo); // 수정
	void deleteMemo(MemoVO memo); // 삭제
	MemoVO selectMemoInfo(int num); // 한건조회
	List<MemoVO> selectAllList(); // 전체조회
	


}
