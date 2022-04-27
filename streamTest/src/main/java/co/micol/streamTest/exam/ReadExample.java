package co.micol.streamTest.exam;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {

	// 메소드
	public void read() {
		try {
			InputStream is = new FileInputStream("C:\\Temp\\test2.txt");
			byte[] buffer = new byte[100];
			while (true) {
				int data = is.read(buffer);
				if (data == -1)
					break;
				for (int i = 0; i < data; i++) {

					System.out.println(buffer[i]);
				}

			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
