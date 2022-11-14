package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("ex03.dat");
		FileOutputStream fos = new FileOutputStream("ex03.copy");
		
		byte[] buffer = new byte[512];
		int readBytes;
		
		while((readBytes = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, readBytes);
			
			System.out.printf("=== %d byte ===\n", readBytes);
			
			String str = "";
			for(int i = 0; i < buffer.length; i++) {
				System.out.printf("%02X ", buffer[i]);
				str += (char)buffer[i];
				
				if((i + 1) % 8 == 0) {
					System.out.println("\t" + str);
					str = "";
				}
			}
			System.out.println();
		}
		
		fis.close();
		fos.close();
	}
}
