package co.micol.prj;

import co.micol.prj.listTest.MapTest;

public class MainApp {

	public static void main(String[] args) {
		//메인메소드 => 자바프로젝트의 시작 및 종료

		//어레이리스트
//		ListTest list = new ListTest();
//		list.listTest();
//		
//		System.out.println("====================");
//		list.studentList();
		
		//셋
//		SetTest setTest = new SetTest();
//		setTest.setTest();   //입력 순서대로 나오지않음. 
		
		
		MapTest mapTest = new MapTest();
		mapTest.mapTest();
		mapTest.studentMap();
		
		
	}

}
