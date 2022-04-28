package co.micol.menuTest;

import java.util.Date;
import java.util.Random;

public class StringExam {

	public static void main(String[] args) {
		
		//a,b는 같은 주소값
		String a = "1";
		String b = "1";
		
		//c,d는 다른 주소값
		String c = new String("1");
		String d = new String("1");
		a= a + b;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("a");
		sb.append("b");
		sb.append("c");
		
//		System.out.println(sb.toString());
		String exam = "1,2,3,4,5,6,7";
		
		String[] temp = exam.split(",");
		
//		for(int i = 0; i<temp.length;i++) {
//		System.out.println(temp[i]);
//		
//	}
		
		Random rd = new Random();
		
		rd.setSeed(0);
		long time = System.currentTimeMillis();
		long time2 = System.nanoTime();
		
				
//		
//		System.out.println(rd.nextDouble()*10);
//		System.out.println(time);
//		System.out.println(time2);
		
		Date date = new Date(0);
		
		
	}

}
