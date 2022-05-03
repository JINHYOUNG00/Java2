package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.notice.dao.DataSource;
import co.micol.student.service.StudentService;
import co.micol.student.service.StudentVO;

public class StudentServiceImpl implements StudentService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection();  //커넥션 연결
	private PreparedStatement psmt;  //sql 명령실행
	private ResultSet rs;	//select 결과를 담음
	
	@Override
	public List<StudentVO> selectListStudent() { //리턴벨류 확인
		//전체 학생 목록 가져오기
		List<StudentVO> students = new ArrayList<StudentVO>(); //리스트는 초기화할수없기때문에 어레이리스트로 
		StudentVO student;
		String sql = "SELECT * FROM STUDENT";  // sql 문장 만들기
		try {
			psmt = conn.prepareStatement(sql); // 커낵션 객체를 통해 sql로 보냄
			rs = psmt.executeQuery(); // sql을 생행하고 결과를 담음.
			
			while(rs.next()) {
				student = new StudentVO();  // 초기화
				student.setStudentId(rs.getString("studentid"));
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);  //리스트 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return students; // 리턴벨류 신경써줘야함
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("Birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setTel(rs.getString("tel"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo; // 리턴벨류 신경써줘야함
	}

	@Override
	public int insertStudent(StudentVO student) { // 한명추가
		int n = 0; // 2 리턴할 변수 생성
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";  ///1 sql 생성
		try {   // 3.트라이 캐치 
				// 4. sql에서 테이블 불러와서 vo객체에 저장.
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();  //5. 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
		
		
	}

	@Override
	public int updateStudent(StudentVO student) {
		// 업데이트
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, "
					+ "ADDRESS = ?, TEL =? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		//한명삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}