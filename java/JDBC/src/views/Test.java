package views;

import dao.USER_TBL_DAO;
import vo.USER_TBL_VO;

public class Test {

	public static void main(String[] args) {
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_VO vo = new USER_TBL_VO();
		
//		vo.setAge(10);
//		vo.setId("cho2");
//		vo.setName("조창현");
//		vo.setPhoneNumber("01092701940");
//		vo.setPw("1234");
//		
//		//회원가입 test
//		if(dao.join(vo)) {
//			System.out.println("회원가입성공");
//		}else {
//			System.out.println("회원가입실패");
//		}
//		
		//로그인 test
//		if(dao.login("cho2", "lmp_dg")) {
//			System.out.println("로그인 성공");
//		}else {
//			System.out.println("로그인 실패");
//		}
		
//		
//		if(dao.logout()) {
//			System.out.println("로그아웃 성공");
//		}else {
//		System.out.println("로그아웃 실패");
//	}
//		
		
//		if(dao.delete("1234")) {
//			System.out.println("회원탈퇴성공");
//			dao.logout();
//		}
//		dao.findPw("cho2", "01092701940");
		
		
	}
}
