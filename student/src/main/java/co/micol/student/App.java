package co.micol.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App {
	public static void main(String[] args) {
		StudentService dao = new StudentServiceImpl();
    	List<StudentVO> list = new ArrayList<StudentVO>();
    	
    	list = dao.selectListStudent();
    	
    	for(StudentVO vo : list) {
    		vo.toString();
    		System.out.println();
    	}
    
//    	System.out.println("=============================");
//    	StudentVO student = new StudentVO();
//    	student.setStudentId("jin.0213@gmail.com");
//    	student = dao.selectStudent(student);
//    	student.toString();

//		StudentVO vo = new StudentVO();
//		vo.setStudentId("rasd@asdfsadf.com");
//		vo.setName("고길동");
//		vo.setBirthday(Date.valueOf("2010-01-01"));
//		vo.setMajor("경영학부");
//		vo.setAddress("대구광역시 중구");
//		vo.setTel("010-0000-0001");
//
//		int n = dao.insertStudent(vo);
//		if (n != 0) {
//			System.out.println("정상적으로 입력이 되었습니다.");
//		} else {
//			System.out.println("입력 실패했습니다.");
//			
//		} 

	}
}
