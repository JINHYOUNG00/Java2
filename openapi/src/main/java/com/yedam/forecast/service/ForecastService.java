package com.yedam.forecast.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.yedam.app.common.PropertiesPair;
import com.yedam.forecast.service.vo.WeatherInfo;

public class ForecastService {

	// 동네예보 - 육상예보를 조회하는 서비스
	public static List<WeatherInfo> getWeatherForecast() {
		String key = "bzXoxqF9YoUX+r2whKcyrxc7kZwDyKpEGAjDa3jOCFAd0WJV0u3F2tsxF8DYaJZHV+AcU3QgwJZ7PkNzZEHcDQ==";

		String serviceURL = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst?";

		List<PropertiesPair> params = new ArrayList<PropertiesPair>();

		params.add(new PropertiesPair("ServiceKey", key));
		params.add(new PropertiesPair("pageNo", "1"));
		params.add(new PropertiesPair("numOfRows", "10"));
		params.add(new PropertiesPair("dataType", "JSON"));
		params.add(new PropertiesPair("regId", "11A00101"));

		StringBuilder sb = new StringBuilder();
		try {
			String paramURL = PropertiesPair.getQuery(params);
			String requestURL = serviceURL + paramURL;
			URL url = new URL(requestURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/json");

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
		return getWeatherData(jsonResult);

	}

	private static List<WeatherInfo> getWeatherData(String jsonData) {
		List<WeatherInfo> list = new ArrayList<WeatherInfo>();
		try {
			JSONParser parser = new JSONParser();

			JSONObject forecastData = (JSONObject) parser.parse(jsonData);

			JSONObject response = (JSONObject) forecastData.get("response");
			JSONObject body = (JSONObject) response.get("body");
			JSONObject items = (JSONObject) body.get("items");
			JSONArray item = (JSONArray) items.get("item");
			
			for(int i=0;i<item.size();i++) {
			JSONObject data = (JSONObject) item.get(i);
			WeatherInfo info = new WeatherInfo();
			
			//발표시간 - 필수			
//			info.setAnnounceTime((long)data.get("announceTime"));
			info.setAnnounceTime(Long.parseLong(data.get("announceTime").toString()));
			//발표번호 - 옵션
			info.setNumEf((data.get("numEf") == null)? 0 : Long.parseLong(data.get("numEf").toString()));
		
			//예보구역코드 - 필수
			info.setRegId((String) data.get("regId"));
			//강수확률 - 필수
			info.setRnSt((data.get("rnSt") == null)? 0.0 : Double.parseDouble(data.get("rnSt").toString()));//(double)data.get("rnSt"));
			//강수형태 - 필수
			info.setRnYn(Integer.parseInt(data.get("rnYn").toString()));
			//예상기온 - 옵션
			info.setTa((data.get("ta") == null)? 0.0 : Double.parseDouble(data.get("ta").toString()));//(double)data.get("ta"));
			//날씨 - 필수
			info.setWf((String)data.get("wf"));
			//하늘상태 - 필수
			info.setWfCd((String)data.get("wfCd"));
			//풍속강도코드 - 필수
			info.setWsIt(Integer.parseInt(data.get("wsIt").toString()));
			list.add(info);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
