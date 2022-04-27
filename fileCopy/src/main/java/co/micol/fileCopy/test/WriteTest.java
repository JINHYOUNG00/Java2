package co.micol.fileCopy.test;

import java.io.FileWriter;
import java.io.Writer;

public class WriteTest {
	
	public void write() {
		ReadTest rt = new ReadTest();
		try {
			Writer writer = new FileWriter("C:\\Temp\\Object.txt");
			
			writer.write();
			
			writer.flush();
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
