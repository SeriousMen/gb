package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//ALT + SHIFT +R Rename하는 단축키
public class DBConnecter {
	private static final String PATH = "boxOffice.txt";

	static String getPath() {
		return PATH;
	}
	//Setter는 FINAL이라서 안나옴
	//쓰기편하라고 static선언
	
	//데이터 추가
	public static BufferedWriter getAppend() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
		return bw; //컨트롤러에서 close() 
	}
	
	//데이터 가져오기 
	public static BufferedReader getReader() throws IOException{
		BufferedReader	br = null;
		try {br = new BufferedReader(new FileReader(PATH));
		} catch (Exception e) {;}
			return br;
		}
	
	//데이터 덮어쓰기
	
	public static BufferedWriter getWriter() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
				return bw;
	}
	
	

}
