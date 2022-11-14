package serialize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Handler handler = new Handler();
		
		
		int select;  //메뉴 선택
		String title;
		Date date;
		Todo todo = null;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

		
		do {
			
			System.out.println("1. 목록");
			System.out.println("2. 추가");
			System.out.println("3. 삭제");
			System.out.println("0. 저장 완료");
			select = Integer.parseInt(sc.nextLine());
			
			
			switch(select) {
			
			case 1:
				handler.showList();
				break;
			
			case 2:
				
				System.out.println("이름 : "); title = sc.nextLine();
				System.out.println("날짜 : (yyyy.MM.dd) "); date = sdf.parse(sc.nextLine());
				todo = new Todo(title, date);
				handler.insert(todo);
			
				break;
			case 3 :
				
				System.out.println("삭제할 이름 입력 : ");
				title = sc.nextLine();
				handler.delete(new Todo(title, sdf.parse("2020.11.11")));
				
				break;
				
			case 0:
				handler.save(); //메인이 종료되기 직전 저장한다.
				sc.close();
				break;

			
			}
			
		}while(select !=0);
		System.out.println("종료");
		
		
		
		
	}
}


