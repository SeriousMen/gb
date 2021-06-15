package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTest3 {

	
	public static void main(String[] args) throws IOException {
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt",true));
		
		
//		bw.write("기쁨\n");
//		bw.write("사랑\n");
//		bw.write("행복\n");
//		bw.write("희열\n");
//		bw.close();
		
		//추가(이어쓰기)
		//"신남" 
//		bw.write("신남\n");
//		bw.close();
		
		//수정 (원본파일에 있는 내용을 수정하기) (사랑 -> 슬픔)
//		BufferedReader br = null;
//		String temp = "";
//		String line = null;
//		try {
//			br = new BufferedReader(new FileReader("feeling.txt"));
//			
//			while((line = br.readLine()) != null){
//				//contain() : 포함되어 있는 것 모두
//				//equals() :정확히 일치하는 것만 
//				//삭제(슬픔삭제)
//				if(line.equals("슬픔")) {
//					
////					temp += "슬픔\n";
//					
//					continue;
//				}
//				temp += line + "\n"; //가져올 떄 줄바꿈안가져와서 
//			}
//		} catch (Exception e) {
//			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//		}finally {
//			try {
//				if(br!=null) {
//					br.close();
//				}
//			} catch (Exception e) {
//				throw new RuntimeException();
//			}
//		}
//		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
//		
//		bw.write(temp);
//		bw.close();
//			
	
		//전체 목록 (Ar<객체>)
		
		BufferedReader br = null;
		ArrayList<String> contents = null;
		
		try {
			br = new BufferedReader(new FileReader("feeling.txt"));
			
			contents = new ArrayList<>();
			String line = null;
			
			while((line = br.readLine()) !=null) {
				contents.add(line);
			}
			contents.forEach(content ->System.out.println(content));
		} catch (Exception e) {
			System.out.println("파일없음");
		}finally {
			
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		
	}
	
}
