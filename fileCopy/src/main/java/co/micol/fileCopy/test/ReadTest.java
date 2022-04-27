package co.micol.fileCopy.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReadTest {

	public void read() {
		try {
			Reader read = new FileReader("C:\\Temp\\source.txt");
			
			byte[] buffer = new byte[100];
			while (true) {
				int data = read.read();
				if (data == -1)
					break;
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
