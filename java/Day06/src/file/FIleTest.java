package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FIleTest {
	//RuntimeException을 상속받은 Exception들은 실행 시 오류가 나고, 컴파일 시에는 오류가 나지 않는다.
	//따라서 예외처리가 강제적이지 않다.
	//하지만 Exception을 바로 상속받은 예외들은 어떠한 특정 로직에 의해서 컴파일 시 오류가 발생하기 떄문에
	//반드시 예외처리를 해주어야 한다.
	
	public static void main(String[] args) throws IOException{ // 컴파일 상에서도 오류가 발생한다는 것 
		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt",true));
		//줄바꿈
		
//		bw.newLine();
//		bw.write("\n한동석");
//		bw.write("\r\n한동석"); //r은 리턴 n은 줄바꿈엔터 근데 자바에서 \n만해줘도 둘다해줌 왜?
		/**
		 * 운영체제별로 줄바꿈 문자가 다르다. 이떄 자바 소스코드에 \n을 사용하여 줄바꿈을 한다면
		 * 운영체제별로 줄바꿈이 인식되지 않는다.
		 * 자바 프로그램은 JVM이 실행하고, JVM이 운영체제에 맞는 줄바꿈 문자로 바꿔준다.
		 * 따라서 우리 자바개발자는 그냥 \n을 사용하면 된다.
		 * Windows에 \r은 return의 약자이다.
		 * 하지만 가끔 \n이 파일 Reader에서 잘 인식이 안될 떄가 있다. 
		 */
		
		
		/**
		 * FileWriter("경로",추가여부);
		 * 추가여부는 default로 false이다. 따라서 매번 실행할 떄 마다 전체 내용이 지워진 후 추가된다.
		 * true를 전달하면 기존 내용을 유지하고 맨 아래에 새로운 내용이 추가된다. 
		 */
//		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt",true)); // boolean 타입에 append할껀지 여부에 true 아무것도 안쓰면 false
//		bw.write("한동석"); 
//		bw.close(); //close를 해야 buffer에서 flush한다음 출력됨 
		
		
		
		////////////////////불러오기
//		
//		BufferedReader br =null;
//		String line = null;
//		
//		try {
//			br= new BufferedReader(new FileReader("test.txt"));
//			
//			while((line = br.readLine())!=null) { // 혹은true하고 아래 
////				line= br.readLine();
////				if(line == null) {
////					break;
////				}
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//		}finally {
//			if(br !=null) {
//				try {
//					br.close();
//				} catch (Exception e) {
//					throw new RuntimeException(e.getMessage());
//				}
//			}
//		}
		
	}
}
