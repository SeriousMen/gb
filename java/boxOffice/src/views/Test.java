package views;

import java.io.IOException;

import dao.BoxOfficeDAO;
import vo.BoxOfficeVO;

public class Test {
	public static void main(String[] args) {
		
		BoxOfficeDAO dao = new BoxOfficeDAO();
		
		BoxOfficeVO film_vo = new BoxOfficeVO();
		//추가 , 삽입 
//		film.setRanking(7);//7위에 삽입 
//		film.setFilmName("겨울왕국2");
//		
//		try {
//			dao.insertOrAppend(film);
//		} catch (IOException e) {
//			
//		} 
		
		//수정 
//		try {
//			if(dao.update("겨울왕국2", "여름왕국")) {
//				System.out.println("수정성공");
//			}
//			
//		} catch (IOException e) {			
//		}
//		
		
		//삭제
//		try {
//			dao.delete("노아");
//			System.out.println("삭제성공");
//		} catch (IOException e) {}
		
		//검색 
//		try {
//			dao.select("7").forEach(film->{
//				System.out.println(film.getFilmName());
//			});
//		} catch (IOException e) {}
		
		
		//전체 목록 출력
	      try {
	          dao.selectAll().forEach(film -> {
	             System.out.print(film.getRanking() + "\t");
	             System.out.print(film.getFilmName() + "\t");
	             System.out.print(film.getIncome() + "\t");
	             System.out.print(film.getGuestCnt() + "\t");
	             System.out.println(film.getScreenCnt());
	             
	          });
	       } catch (IOException e) {
	       }

		
		
		
		
		
		
		
		
		
		
		// 과연 \n도 readline()이 가져올까?
		
//		BoxOfficeDAO dao = new BoxOfficeDAO();
//		BoxOfficeVO vo = new BoxOfficeVO();
//		vo.setFilmName("한동석은 짱");
//		vo.setGuestCnt(10);
//		vo.setIncome(10000);
//		vo.setReleaseDate("2009-12-17");
//		vo.setScreenCnt(10);
//		
//		try {	dao.append(vo);} catch (IOException e) {;}
//		try {	dao.append(vo);} catch (IOException e) {;}
	}
}





