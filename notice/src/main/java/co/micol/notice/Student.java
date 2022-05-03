package co.micol.notice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.student.service.StudentService;
import co.micol.student.service.StudentVO;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class Student {

	StudentService dao = new StudentServiceImpl();
	List<StudentVO> list = new ArrayList<StudentVO>();
	Scanner scn = new Scanner(System.in);
	public void selectListStudent() {

		list = dao.selectListStudent();

		for (StudentVO vo : list) {
			vo.toString();
			System.out.println();
		}

	}

	public void selectStudent() {
		StudentVO student = new StudentVO();
		System.out.println("검색할 학생ID >>");
		String studentId = scn.nextLine();
		student.setStudentId(studentId);
		student = dao.selectStudent(student);
		student.toString();

	}

	public void insertStudent() {

	}

	public void updateStudent() {

	}

	public void deleteStudent() {

	}

}
