package dao;

import java.awt.dnd.DnDConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.BoxOfficeVO;

//컨트롤러
public class BoxOfficeDAO {
	//메소드의 공통된 코드를 생각 버퍼드라이트(덮어쓰기,추가쓰기), 버퍼드리더

	
	
	//private 추가(랭킹이 전달되지 않았을 떄) // private 이유: 외부에서 사용하는게아니라 박스오피스 DAO에서 사용할 거라서 	
	private boolean append(BoxOfficeVO film) throws IOException{
		//외부에서 전달된 영화 정보가 없을 때
		if(film == null) {return false;}
		
		BufferedReader br = DBConnecter.getReader(); //일단 읽어온다.
		//해당 경로에 읽어올 파일이 없을 때
		if(br==null) {return false;}
		
		//메모장 각 줄(라인) 문자열을 저장할 변수
		String line = null;
		//마지막 랭킹 번호를 저장할 변수 
		int lastRanking =0;
		
		//while문 종료 시 lastRanking에는 마지막 영화 순위가 저장된다.
		while((line = br.readLine())!=null) {
			//마지막 랭킹을 알아야한다.
			lastRanking ++;
		}
//		System.out.println(lastRanking);
		br.close();
		

		//텍스트파일에서 각 컬럼의 구분은 \t로 구성되어 있다.
		 
		//파일의 가장 마지막 문자가 \n인지 검사(readAllBytes()사용)
		
		String contents = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath()))); // 메모장 전체 문자열
		
		//메모장 양식에 맞춰서 추가할 요소를 담아줄 임시 저장공간
		String temp = ""; //연결을 하려고 ""로 초기화 
		
		//가장 마지막에 줄바꿈이 있는 지 검사 
		if(contents.charAt(contents.length()-1)!= '\n') { // -1해준것은 인덱스는 길이의 -1이기 떄문에 ='\n'이 없다는 건 줄바꿈이 없다는것
			//줄바꿈이 없다면 \n을 추가하고 시작한다.
			temp += "\n";
		}
		
		//새롭게 추가될 영화순위는 마지막 순위 +1이 된다. 
		temp += lastRanking+1+"\t"
		+film.getFilmName()
		+"\t"+film.getReleaseDate()
		+"\t"+film.getIncome()
		+"\t"+film.getGuestCnt()
		+"\t"+film.getScreenCnt()+"\n"; //500개에서 501로 추가하기위해 +1 // 마지막 \n은 넣어도 되고 안넣어도 된다.
		
		BufferedWriter bw = DBConnecter.getAppend();
		bw.write(temp);
		bw.close();
		return true;
	}
	
	
	
	
	
	
	//private 삽입(랭킹이 전달되었을 때) 
	private boolean insert(BoxOfficeVO film) throws IOException{
		
		if(film == null) {return false;}
		
		//전달 받은 삽입할 랭킹을 newRanking에 담아준다.
		int newRanking = film.getRanking();
		
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		
		String line = null; //원본을 담을 것 
		String temp = "";
		
		//삽입 여부 FLAG
		boolean check = false;
		while((line = br.readLine()) != null) {
			//삽입할 순위를 기존 테이터와 비교
		if(Integer.parseInt(line.split("\t")[0]) == film.getRanking()){//라인을 탭을 기준으로 나눈다. 한라인이 탭을 기준으로6칸짜리 배열이 만들어짐
			//현재 순위와 삽압할 순위가 일치하면 기존정보 이전에 새로운 삽입할 정보를 temp에 넣어준다.//새로운 몇등을 넣고 기존에 몇등을 넣는다.
			temp += film.getRanking() 
					+"\t"+film.getFilmName()
					+"\t"+film.getReleaseDate()
					+"\t"+film.getIncome()
					+"\t"+film.getGuestCnt()
					+"\t"+film.getScreenCnt()+"\n"; //H.변수하나에 중복되는 거 담아서 하나만 선언하게 해보기
			check = true; // 삽입완료 
		}
		
		//삽입이 되고나서 true
		if(check) {
			//삽입 후 나머진 랭킹에 모두 +1을 하여 수정해준다. -> 삽입을 하니까 랭킹을 하나씩 밀리게하려고
			//line.subString(line.indexOf("\t")):  순위를 제외한 나머지 정보 
			temp+= ++ newRanking + line.substring(line.indexOf("\t")) + "\n"; //새로운 순위+\t부터 +마지막에 \n
		}else {//삽임이 안될 때 
			//삽입 전에는 순위를 그대로 유지해야한다.
			temp += line + "\n";
			
		}
	}
		br.close();
		BufferedWriter bw =DBConnecter.getWriter();
		bw.write(temp);
		bw.close();
		
		
	
		return true;
	}
	
	
	
	
	//INSERT
	public boolean insertOrAppend(BoxOfficeVO film) throws IOException {
		//랭킹유무판단 
		if(film.getRanking() == 0) {
			//랭킹이 없다면 //추가
			if(append(film)) {return true;}
		}else {
			//삽입
			//삽입할 때 전달받은 랭킹이 마지막 순위보다 클 때(오류)
			String contents = new String(Files.readAllBytes(Paths.get(DBConnecter.getPath())));
			String[] arTemp = contents.split("\n");
			if(Integer.parseInt(arTemp[arTemp.length-1].split("\t")[0])< film.getRanking()) {return false;}//-->오류안나게
				//-> 마지막 랭킹의 순위보다 전달받은 순위가 더크면 오류니까 return false;
			if(insert(film)) {return true;}
		}
		
		return false;
		
	}
	
	
	//수정(영화제목만 수정할수 있게)
	public boolean update(String filmName, String newFilmName) throws IOException {
		
//		BufferedReader br = DBConnecter.getReader();
//		if(br == null) {return false;}
//		String line = null;
//		String temp = "";
//		filmName= newFilmName;
//		br.readLine();
		
		//선생님 ver
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}
		String temp = "";
		String line = null;
		//수정완료여부 flag
		boolean check = false;
		while((line = br.readLine()) !=null) {
			//메모장에서 한줄씩 가져온 후 수정할 영화제목을 비교하여 검사한다.
			if(line.split("\t")[1].equals(filmName)) {
				//\t제목\t정보1..
				String stub = line.substring(line.indexOf("\t")+1);//순위 전까지 자르고
				//일치하는 영화제목이 있다면 새로운 영화제목으로 변경한다.
				temp += line.split("\t")[0] +"\t"+newFilmName+stub.substring(stub.indexOf("\t")) +"\n";//다시 영화제목전까지 잘라준다.
					//순위는 그대로 유지 \t하고 새로운 영화제목 
				check = true;
				continue;
			}
			temp += line + "\n";
			
		}
		br.close();
		
		//수정이 되었다면 덮어쓴 후 true 리턴 
		
		if(check) {
			BufferedWriter bw =DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
			return true;
	}
	return false;
	}
	
	//삭제 (영화제목은 중복이 없단는 가정하에)
	public boolean delete(String filmName) throws IOException {
		BufferedReader br = DBConnecter.getReader();
		if(br==null) {return false;}
		
		String line =null;
		String temp = "";
		int ranking = 0;
		
		boolean check =false;
		
		while((line = br.readLine()) != null){
			ranking ++;
			if(line.split("\t")[1].equals(filmName)) {
				ranking --;
				check = true;
				continue;
			}
			temp += ranking + line.substring(line.indexOf("\t")) +"\n";
		}
		
		
		br.close();
		
		if(check) {
			BufferedWriter bw = DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
			return true;
		}
		return false;
	}
	
	//검색
		public ArrayList<BoxOfficeVO> select(String keyword) throws IOException{
			BufferedReader br = DBConnecter.getReader();
			ArrayList<BoxOfficeVO> filmList = new ArrayList<>();
			if(br == null) {return null;}
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] arTemp = line.split("\t");
				if(arTemp[1].contains(keyword)) {
					BoxOfficeVO film = new BoxOfficeVO();
					
					film.setRanking(Integer.parseInt(arTemp[0]));
					film.setFilmName(arTemp[1]);
					film.setReleaseDate(arTemp[2]);
					film.setIncome(changeToLong(arTemp[3]));
					film.setGuestCnt(changeToInteger(removeS(arTemp[4])));
					film.setScreenCnt(changeToInteger(removeS(arTemp[5])));
					
					filmList.add(film);
				}
			}
			br.close();
			return filmList;
		}
		//목록
		public ArrayList<BoxOfficeVO> selectAll() throws IOException{
			BufferedReader br = DBConnecter.getReader();
			ArrayList<BoxOfficeVO> filmList = new ArrayList<>();
			if(br == null) {return null;}
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] arTemp = line.split("\t");
				BoxOfficeVO film = new BoxOfficeVO();
					
				film.setRanking(Integer.parseInt(arTemp[0]));
				film.setFilmName(arTemp[1]);
				film.setReleaseDate(arTemp[2]);
				film.setIncome(changeToLong(arTemp[3]));
				film.setGuestCnt(changeToInteger(removeS(arTemp[4])));
				film.setScreenCnt(changeToInteger(removeS(arTemp[5])));
				
				filmList.add(film);
			}
			br.close();
			return filmList;
		}
		
		public int changeToInteger(String includedComma) {
			String [] arTemp = includedComma.split(",");
			String result = "";
			for(int i = 0; i<arTemp.length; i++) {
				result += arTemp[i];
			
						
			}
			if(includedComma.equals("")) {result = "0";}
			return Integer.parseInt(result);
		}
		public long changeToLong(String includedComma) {
			String [] arTemp = includedComma.split(",");
			String result = "";
			for(int i = 0; i<arTemp.length; i++) {
				result += arTemp[i];
			
						
			}
			if(includedComma.equals("")) {result = "0";}
			return Long.parseLong(result);
		}
		
		public String removeS(String screenCnt) {
			if(screenCnt.contains("S")) {
				screenCnt = screenCnt.substring(screenCnt.indexOf("S") + 2);
			}
			
			return screenCnt;
		}
	}














