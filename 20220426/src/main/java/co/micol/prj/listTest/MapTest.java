package co.micol.prj.listTest;

import java.util.HashMap;
import java.util.Map;

import co.micol.prj.dto.StudentVO;

public class MapTest {

	public void mapTest() {
		Map<String, String> map = new HashMap<String, String>();    //Map은 키값과 벨류값을 대입
		map.put("name", "홍길동");
		map.put("address", "대구광역시");
		
		//출력할때는 키값을 넣으면 벨류값이 출력된다.
		System.out.println(map.get("name"));
		System.out.println(map.get("address"));
	}
	
	public void studentMap() {
		Map<Integer,StudentVO> map = new HashMap<Integer, StudentVO>();
		map.put(95,new StudentVO("홍길동"));
		map.put(85, new StudentVO("박길동"));
		map.put(100, new StudentVO("김길동"));
		
		 System.out.println(map.get(1));
		
	}
	
}
