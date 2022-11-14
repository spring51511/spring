package serialize;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("ex01.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<String> list = (ArrayList<String>) ois.readObject();
		System.out.println("불러온 리스트 : "+ list);
		
		ois.close();
		
	}
}
