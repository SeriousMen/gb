package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC : Java Database Connectivity 
public class DBConnector { //--> 데이터베이스와 연결하기 위한 클래스를 선언  

	public static Connection getConnection() { // 어디서나 고정적으로 쓸거니까 메소드를 public static으로 
		Connection conn = null;
		//url, id,pw
		try {
			
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 내 오라클 주소 작성 @ip주소:리스너포트번호:SID
		String user ="hr";	//접속을 위해 유저 ID와 아래 PW입력 
		String pw = "hr";	//이렇게 정보가 노출되기 떄문에 나중에는 외부에 파일에서 정보를 불러온다.
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩: 드라이버인터페이스를 구현한 클래스 로딩
		conn = DriverManager.getConnection(url,user,pw); // 연결(connection맺기)
		System.out.println("DB연결 성공");
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		} catch(Exception e) {
			System.out.println("getConnection() 알 수 없는 오류 ");
		}
		return conn;	//JDBC연결된걸 리턴 
	}
}
