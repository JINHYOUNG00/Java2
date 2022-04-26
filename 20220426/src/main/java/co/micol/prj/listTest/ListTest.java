package co.micol.prj.listTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.dto.StudentVO;

public class ListTest {
	public void listTest() {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박길동");
		list.add("이승리");
		
		for(String str : list) {
			System.out.println(str);
		}
	}
	
	
	public void studentList() {
		
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student = new StudentVO();
		student.setStudentId("202204001");
		student.setName("홍길동");
		student.setAge(20);
		student.setBirthDay(Date.valueOf("2002-03-01"));   // 스트링을 날짜타입으로 바꿔줌
		student.setGender("F");
		students.add(student); //리스트에 담음.
		
		student = new StudentVO(); //student2를 생성하지않고 기존객체를 초기화해서 재사용
		student.setStudentId("202204002");
		student.setName("김길동");
		student.setAge(21);
		student.setBirthDay(Date.valueOf("2001-03-01"));   // 스트링을 날짜타입으로 바꿔줌
		student.setGender("W");
		students.add(student); //리스트에 담음.
		
		for(StudentVO vo : students) {
			vo.toString();
			System.out.println(vo.getStudentId()); //그냥 get만쓰면 데이터만 읽어보겠다는 의미.
		}
	}
	
	
	

}
