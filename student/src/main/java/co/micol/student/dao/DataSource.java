package co.micol.student.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
							
	//싱글톤 클래스 패턴
	
	// 클래스 객체를 하나 만들고
	private static DataSource dataSource = new DataSource();
	// 외부에서 호출 못하게 프라이빗으로 지정해서 생성자 만들고
	private DataSource() {};
	
	private Connection conn; // 자신을 객체로 만들고
	private  String driver;// = "oracle.jdbc.driver.OracleDriver";
	private String url;// = "jdbc:oracle:thin:@localhost:1521:xe";
	private  String user;// = "jin";
	private  String password;// = "1234";

	public static DataSource getInstance() {
		return dataSource;
	}
	public Connection getConnection() {  //static
		dbconfiguration();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패!");
		} 
		
		return conn;
	}
	
	private void dbconfiguration() { //리소스파일을 읽어올수있게끔해줌       //static
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	} 
	
	
}
