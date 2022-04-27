package co.micol.streamTest.exam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriterExample {
	//멤버변수
	//생성자
	//메소드
	public void run() {
		try {
			OutputStream os = new FileOutputStream("C:\\Temp\\test2.txt");
			byte[] array = {'A','B','C'};
			
			os.write(array);
			
			os.flush();
			
			os.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	

}
