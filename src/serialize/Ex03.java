package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Todo implements Comparable<Todo>, Serializable {
	// 1) private 필드를 작성하고 저장한다
	// 2) 저장 이후 우클릭 - s, o (필드를 매개변수로 전달받는 생성자 자동 작성)
	// 3) 저장 이후 우클릭 - s, r - alt + a, r (각 필드에 대한 getter/setter 자동 작성)
	
	private static final long serialVersionUID = 6737531346498093713L;
	// 직렬화 하여 전송 이후 재 조립할 때 (역직렬화) 원래 자료형이 맞는지 확인하기 위한 식별값
	
	private String title;
	private Date date;
	
	public Todo(String title, Date date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return String.format("[%s]\t%s", title, sdf.format(date));
	}

	@Override
	public int compareTo(Todo o) {
		return this.date.compareTo(o.date);
	}
}

public class Ex03 {
	public static void main(String[] args) throws ParseException, IOException {
		
		ArrayList<Todo> list = new ArrayList<Todo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		list.add(new Todo("원종래 생일", sdf.parse("2022.12.22")));
		list.add(new Todo("빼빼로데이", sdf.parse("2022.11.11")));
		list.add(new Todo("응용SW평가(필기)", sdf.parse("2022.11.15")));
		list.add(new Todo("김도현 생일", sdf.parse("2022.11.04")));
		list.add(new Todo("김대현 생일", sdf.parse("2022.12.19")));
		
		list.sort(null);
		
		list.forEach(todo -> System.out.println(todo));
		
//		FileOutputStream fos = new FileOutputStream("ex03.dat"); 
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ex03.dat"));
		oos.writeObject(list);
		oos.flush();
		oos.close();
		
		System.out.println("저장 완료 !!");
		
	}
}














