package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.USER_TBL_VO;

public class USER_TBL_DAO {
	
	public static String session_id; //서버대신 응용프로그램까지는 저장하려고 
	//String id = "hds";
	
	//[Statement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = \'"+ id + "\'"; 
	
	//[PreparedStatement]
	//String query = "SELECT * FROM USER_TBL WHERE ID = ?";
	//pstm.setString(1,id);
	
	//main 메소드 내에서 선언된 게 아니니까 public 타입의 클래스(인터페에스)를 선언할 수 있지 
	private static final int key = 3; //모든 DAO객체가 공유할 수 있게끔 Static선언 
	Connection conn;	// 접속에 성공한 DB의 연결 객체 
	PreparedStatement pstm;	//JAVA에서 문자열로 작성한 쿼리문을 저장하고,
							//?에 필요한 값을 채운 후 쿼리를 실행시켜 준다.
	ResultSet rs;	// 조회 결과 값을 담을 수 있는 객체 
	
	//아이디 검사
	public boolean checkId(String id) {
		//COUNT(컬럼) --> 결과 집계함수
		// CONNT(*) :결과 행의 개수 -->결과는 0또는 1 0이면 중복없음 1이면 중복 
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ?";
		boolean check = false;
		
		try {
			
			conn = DBConnector.getConnection();// 커넥션 객체 가져옴
			pstm = conn.prepareStatement(query);//가져온 커넥션 객체를 통해 prepareStatement 실행 후 pstm 객체에 넣기
			pstm.setString(1, id); //JDBC는 0이 아니라 1부터 ?을 값을 채운다.  /에 들어갈 값 설정
			rs = pstm.executeQuery(); // 쿼리를 실행하고 결과가 있다면 값을 rs에 담아 준다. why? 자바에서 그 결과를 가져와야 하니까 
			
			rs.next(); //행에 접근해서 한 행씩 가져온다. 
			if(rs.getInt(1)==1) {// 열 가져오기 
				check = true;  // 아이디 검사 후 존재한다면 1, 존재하지 않으면 0 
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("checkId() 알 수 없는 오류 ");
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 원인파악
				//예외가 발생하면 무조건 강제 종료 된다. 
			}
		}
		return check;
		
		
	}
	
	//회원가입(암호화 후 DB추가)
	public boolean join(USER_TBL_VO user) {
//		USER_NUMBER NUMBER NOT NULL,
//		ID VARCHAR2(100),
//		PW VARCHAR2(100),
//		NAME VARCHAR2(100),
//		AGE NUMBER, --부동 소수점 표현
//		PHONENUMBER VARCHAR2(15),
		//회원 번호는 SEQ 사용
		//USER_SEQ.NEXTVAL : 시퀀스 가져오기
		//INSERT쿼리문사용
		String query = "INSERT INTO USER_TBL VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)";
		boolean check = false; 
		//사용자가 입력한 아이디를 DB에서 검사한다. 
		
		
//		if(checkId(user.getId())) { // if문이 true일떄 실행하니까 중복이라면  
//			//true일 떄 중복이 있다는 뜻 
//			return check; //회원가입 안에 중복검사를 하면 회원가입 정보를 다 입력하고나서 중복여부가 나와서 비효율적 
//		}	--> view에서 사용할 것 
		
		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			//SELECT외의 INSERT, UPDATE, DELETE 쿼리문은 결과 건수를 가져와 확인하면 된다.
			//executeQuery() : SELECT의 결과를 리턴해주는 메소드(ResultSet)
			//executeUpdate() :  INSERT, UPDATE, DELETE의 결과 건수를 리턴해주는 메소드(int)
			int idx =0;
			pstm.setString(++idx, user.getId());
			pstm.setString(++idx, encrypt(user.getPw()));
			pstm.setString(++idx, user.getName());
			pstm.setInt(++idx, user.getAge());
			pstm.setString(++idx, user.getPhoneNumber());
			
			if(pstm.executeUpdate() == 1) {
				check = true;
				
			}
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류 ");
		} finally {
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 강제적으로 종료하기 위해서
				//예외가 발생하면 무조건 강제 종료 된다. 
			}
		}
	
		
		//회원번호는 SEQ사용
		//USER_SEQ.NEXTVAL : 시퀀스 가져오기 
		
		return check; // false다.
		
	}
	//로그인 -->로그인 성공 실패 여부  이상황에서는 COUNT(*)하면 0또는 1 리턴이 되니까 where에서 id랑 pw써줘서  
	public boolean login(String id, String pw) { //딱 필요한 데이터만 매개변수로 선언 
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ? AND PW =? ";
		boolean check = false;
		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			
			rs = pstm.executeQuery();
			
			//행
			rs.next(); // 행이 하나니까 while문 쓸 필요가 없음  // Q.근데 이거 굳이 왜해 ? 그냥 아래 if문하면되는거아니야 ??
			//열
			if(rs.getInt(1) == 1) {
				check = true;
				//로그인된 회원의 id를 저장 
				session_id = id;
			}
			
		}  catch (SQLException e) {
			System.out.println("login() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("login() 알 수 없는 오류 ");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 강제적으로 종료하기 위해서
				//예외가 발생하면 무조건 강제 종료 된다. 
			}
		}
		return check;
		
	}
	
	//로그아웃 
//	public boolean logout(String id, String pw) {
//		//id와 비밀번호가 같은지 여부
//		
//		if(session_id !=null) {
//			session_id = null; //session_id가 로그인시 쓰는 임시저장소 같은건가 ?
//			return true;
//		}
//			
//		return false;
//	}
	   public boolean logout() {
		      if(session_id != null) {
		         session_id = null;
		         return true;
		      }
		      return false;
		   }
		   

	
	//마이페이지
	
	public USER_TBL_VO select(String pw) { // 지금한명이니까 그냥 모델 객체를 리턴타입으로 선언
		
		//view 에서 처리 
//		if(session_id ==null) {
//			return null; 
//	
//		}
		
		USER_TBL_VO user = null;
		String query = "SELECT * FROM USER_TBL WHERE ID = ? AND PW =? ";

		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			//행
			if(rs.next()) {
			user = new USER_TBL_VO();
			user.setId(rs.getString("ID"));
			user.setPw(rs.getString("PW"));
			user.setName(rs.getString("NAME"));
			user.setAge(rs.getInt("AGE"));
			user.setPhoneNumber(rs.getString("PHONENUMBER"));
			
			} }catch (SQLException e) {
				System.out.println("select() 쿼리문 오류 ");
			} catch (Exception e) {
				System.out.println("select() 알 수 없는 오류 ");
			} finally {
				try {
					if( rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if( conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 강제적으로 종료하기 위해서
					//예외가 발생하면 무조건 강제 종료 된다. 
				}
			}
			return user;
			
				//로그인된 회원의 id를 저장 
				
			
		
	}
	//목록(회원전체목록 //전체 정보 불러오기)
	public ArrayList<USER_TBL_VO> selectAll() { // 행이 여러개니까 ArrayList
		USER_TBL_VO user = null;
		String query = "SELECT * FROM USER_TBL ";
		//엑시큐드 쿼리
		ArrayList<USER_TBL_VO> userList = new ArrayList<>();
		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			
			while(rs.next()) { //행이 여러개니까 while문 조건문안에 false이면 실행안하고 true면 실행이니
				user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
				
				userList.add(user);
		} }catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("selectAll() 알 수 없는 오류 ");
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 강제적으로 종료하기 위해서
				//예외가 발생하면 무조건 강제 종료 된다. 
			}
		}
		return userList;
		
		
		
	}
	
	
	
	//삭제(회원 탈퇴)
	public boolean delete(String pw) {
		String query = "DELETE FROM USER_TBL WHERE ID = ? AND PW = ?";
		boolean check = false;
		
		
		try {
			conn=DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			if(pstm.executeUpdate()==1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("delete() 알 수 없는 오류 ");
		} finally {
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); // 실행도중 문제가 생겼을 때(close할때) 강제적으로 종료하기 위해서
				//예외가 발생하면 무조건 강제 종료 된다. 
			}
		}
		return check;
	}

	
	
	//아이디 찾기 (핸드폰 번호와 비밀번호로 아이디 조회)
	
	public String findId(String phoneNumber, String pw ) {//아이디 찾는거니 리턴이 String
		String query = "SELECT ID FROM USER_TBL WHERE PHONENUMBER = ? AND PW = ?";
		String id = null;
		
		try {
			conn=DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phoneNumber);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
					
			if(rs.next()) {
				id= rs.getString(1);
				
			;
			}
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("findId() 알 수 없는 오류 ");
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
			
		return id;
		}
	
	
	
	//수정(비밀번호 변경: 로그인된 상태에서)
	//현재 비밀번호, 새로운 비밀번호 
	public boolean changePw(String pw, String new_pw) {
		String query = "UPDATE USER_TBL SET PW= ? WHERE ID =? AND PW =?";
		boolean check = false;
		
		try {
			conn= DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1,encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));
			
			if(pstm.executeUpdate() == 1) {
				check = true;;
				
			}
		} catch (SQLException e) {
			System.out.println("changePw(String, String) 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("changePw(String, String) 알 수 없는 오류 ");
		} finally {
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
		
		return check;
	}
	
	//수정(비밀번호 변경 임시비밀번호로 변경//비 로그인상태) private으로 		//선생님꺼랑 비교확인 
	//회원번호를 통해 임시비밀번호로 비밀번호 변경
	private void changePw(int user_number, String temp_pw) {
		String query = "UPDATE USER_TBL SET PW =? WHERE USER_NUMBER = ?";
		
		try {
			conn = DBConnector.getConnection();
			pstm=conn.prepareStatement(query);
			pstm.setString(1, encrypt(temp_pw));
			pstm.setInt(2, user_number);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println("changePw(int, String) 쿼리문 오류 ");
		} catch (Exception e) {
			System.out.println("changePw(int, String) 알 수 없는 오류 ");
		} finally {
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				if( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
		
		
		
	}
	
	
	
	

	//숙제
	
	//비번 찾기(아이디와 핸드폰 번호를 전달 받는다.) 
	//회원번호를 통해 임시비밀번호 6자리 생성(Random), SMS API를 사용하여 JSON으로 데이터(수신번호,발신번호,내용 등) 전송
	// 전송된 임시 비밀번호로 UPDATE (위에 임시수정 메소드 통해서)
	//본인 핸드폰에 온 문자 확인 후 임시비밀번호 확인
	public void  findPw(String id,String phoneNumber ) {
		String query = "SELECT USER_NUMBER FROM USER_TBL WHERE ID = ? AND PHONENUMBER = ?";
//		String query = "UPDATE USER_TBL SET PW =? WHERE USER_NUMBER = ?";
		
		
		try {
			conn=DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1,id);
			pstm.setString(2, phoneNumber);
			rs = pstm.executeQuery(); 
			
			if(rs.next()) {
				//임시 비밀번호 생성
				Random r = new Random();
				String temp = "0123456789abcdefghijklmnopqrstuvwxyz~1@#$%^&*()_+{}[];:/?";
				String temp_pw = "";
				final int TEMP_PW_LENGTH = 6;
				
				for(int i =0; i< TEMP_PW_LENGTH; i++) {
					temp_pw += temp.charAt(r.nextInt(temp.length()));
				}
				//비밀번호 변경
				changePw(rs.getInt(1), temp_pw);
				//SMS 문자전송
				String api_key ="NCSO59TP7GWRNGJL";
				String api_secret = "8T7XLZWW8YIAXZLBXQ8XY7PJQEZK44P3";
				Message coolsms = new Message(api_key,api_secret);


				    // 4 params(to, from, type, text) are mandatory. must be filled
				    HashMap<String, String> params = new HashMap<String, String>();
				    params.put("to", "01092701940");
				    params.put("from", "01092701940");
				    params.put("type", "SMS");
				    params.put("text", "[테스트]\n임시 비밀번호:" + temp_pw + "\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
				    params.put("app_version", "JAVA SDK v2.2"); // application name and version

				    try {
				      JSONObject obj = (JSONObject) coolsms.send(params);
				      System.out.println(obj.toString());
				    } catch (CoolsmsException e) {
				      System.out.println(e.getMessage());
				      System.out.println(e.getCode());
				    }
				  }
			
			
		  } catch (SQLException e) {

		}
		
		
		
		}
	
	
	
	//암호화 	--> 복호화는 원래 안함 보안떄문에 
	public String encrypt(String pw) {		
		String en_pw = "";
		for(int i=0; i< pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * key);
	}
		return en_pw;
	}
}
