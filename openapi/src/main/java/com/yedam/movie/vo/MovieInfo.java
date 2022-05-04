package com.yedam.movie.vo;

import java.util.Date;

import lombok.Data;

@Data

public class MovieInfo {
	private int rnum;
	private int rank;
	private int rankInten;
	private String rankOldAndNew;
	private String movieCd;
	private String movieNm;
	private Date openDt;
	private long salesAmt;
	private double salesShare;
	private long salesInten;
	private double salesChange;
	private long salesAcc;
	private long audiCnt;
	private long audiInten;
	private double audiChange;
	private long audiAcc;
	private long scrnCnt;
	private long showCnt;
	
	
	
	
}
