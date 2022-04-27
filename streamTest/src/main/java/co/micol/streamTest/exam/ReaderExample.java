package co.micol.streamTest.exam;

import java.io.FileReader;
import java.io.Reader;

public class ReaderExample {

	public void read() {
		try {
			Reader reader = new FileReader("c:\\Temp\\test2.txt");
			while (true) {
				int data = reader.read();
				if (data == -1) break;
				System.out.println((char) data);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
