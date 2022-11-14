package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex04 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<Todo> list = null;  // list 는 빈칸이라는게 없다. 
		// ex03.dat의 객체를 list에 저장하여 아래 출력코드가 작동할 수 있도록 처리하세요

		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("ex03.dat"));

		list = (ArrayList<Todo>) ois.readObject();
		ois.close();

		for (int i = 0; i < list.size(); i++) {  //  array.list
			Todo t = list.get(i);
			System.out.println(t);
		}
		System.out.println("\n==================================\n");

		for (Todo t : list) {	 // array.list
			System.out.println(t);
		}
		System.out.println("\n==================================\n");

		list.forEach(t -> System.out.println(t));  // list
		// 함수를 이용해서 반복을 처리하지, 반복문 제어문을 이용하지 않아도 처리가 가능하다.
		System.out.println("\n==================================\n");

		list.forEach(System.out::println);	// list
		System.out.println("\n==================================\n");

	}
}
