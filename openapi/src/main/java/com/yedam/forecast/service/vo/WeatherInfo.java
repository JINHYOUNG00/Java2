package com.yedam.forecast.service.vo;

import lombok.Data;

@Data
public class WeatherInfo {
	
	//발표시간 - 필수			
	private long announceTime;
	//발표번호 - 옵션
	private long numEf;
	//예보구역코드 - 필수
	private String regId;
	//강수확률 - 옵션
	private double rnSt;
	//강수형태 - 필수
	private int rnYn;
	//예상기온 - 옵션
	private double ta;
	//날씨 - 필수
	private String wf;
	//하늘상태 - 필수
	private String wfCd;
	//풍속강도코드 - 필수
	private int wsIt;

}
