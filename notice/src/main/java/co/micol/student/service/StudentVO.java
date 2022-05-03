package co.micol.student.service;

import java.sql.Date;

import lombok.Data;

@Data // https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24

public class StudentVO {   //Dto
	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;

	@Override
	public String toString() {
		System.out.print(studentId+" : ");
		System.out.print(name+" : ");
		System.out.print(birthday+" : ");
		System.out.print(major+" : ");
		System.out.print(address+" : ");
		System.out.print(tel);
		
		return null;
	}
	
	

}