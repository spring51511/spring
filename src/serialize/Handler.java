package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Handler {
	
	private List<Todo> list;
	
	public Handler() throws ClassNotFoundException, IOException {
		load();
		System.out.println("데이터를 불러왔습니다");
	}

	

	@SuppressWarnings("unchecked")
	private void load() throws IOException, ClassNotFoundException {// 생성자 내부에서 호출함. 파일에서 객체를 불러와서 리스트에 저장
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("ex03.dat"));  // 객체의 형태로 불러온다. ObjectInputStream
		list = (ArrayList<Todo>) ois.readObject();
		ois.close();
	}
	
	
	public void save() throws  IOException { //main 애서 호출함 .리스트 객체를 파일로 저장
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ex03.dat"));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}


	public int insert(Todo todo) { // 객체를 전달받아서 추가하기
		return list.add(todo) ? 1 : 0;

	}

	public int delete(Todo todo) {// 선택한 객체의 index를 확인하여 제거하기
		
		//int index = -1;
		for (int i = 0; i < list.size(); i++ ) {
			if(list.get(i).getTitle().equals(todo.getTitle())) {
				list.remove(i);			
				//index = i;
	
			}
			
		}
		                                                                                                                           
		
		//if(index != -1)
		//list.remove(index);
		
		return 0;
	
	
	}



	public void showList() {
		
		//list.forEach(todo ->System.out.println(todo));
		
		for(Todo todo : list) {
			System.out.println(todo);
		}
		System.out.println();
	}
}
