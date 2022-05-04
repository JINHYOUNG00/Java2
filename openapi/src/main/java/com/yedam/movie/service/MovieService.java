package com.yedam.movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yedam.app.common.PropertiesPair;
import com.yedam.movie.vo.BoxOfficeResult;
import com.yedam.movie.vo.MovieInfo;

public class MovieService {

	private static final String key = "5580463d264bffac99c6aef081e22a0d"; // 오픈 api 개인키

	// 일별 박스오피스
	public static List<MovieInfo> getDailyBoxOfficeResult() {
		String serviceURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";

		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("key", key));
		params.add(new PropertiesPair("targetDt", "20210430"));

		StringBuilder sb = new StringBuilder();
		try {
			String paramURL = PropertiesPair.getQuery(params);

			String requestURL = serviceURL + paramURL;
			URL url = new URL(requestURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // 서버에 요청
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);

				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			con.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsonResult = sb.toString();
		BoxOfficeResult result = new Gson().fromJson(jsonResult, BoxOfficeResult.class);
		
//		BoxOfficeInfo = result.getBoxOfficeResult();
//		List<MovieInfo> list = info.getDailyBoxOfficeList();
		return result.getBoxOfficeResult().getDailyBoxOfficeList();
		
	}
}
