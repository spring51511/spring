package serialize;



import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> list = new ArrayList<String>(
			Arrays.asList(new String[] {
				"이지은", "홍진호", "나단비", "빼빼로"
			})
		);
		
		FileOutputStream fos = new FileOutputStream("ex01.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);	// implement Serializable 한 객체를 byte단위로 분해하여 저장
		
//		oos.write(buf); 	// 
//		oos.write("빼빼로".getBytes());
		
		oos.flush();
		oos.close();
		
		System.out.println(list);
		
		// 213456789
	}
}
