package vo;
//모델 객체 생성 
//USER_NUMBER NUMBER NOT NULL,
//ID VARCHAR2(100),
//PW VARCHAR2(100),
//NAME VARCHAR2(100),
//AGE NUMBER,
//PHONENUMBER VARCHAR2(15),
public class USER_TBL_VO {
	
	private int user_number;	//어처피 메소드를 통해 접근할 꺼니까 필드는 다 private 선언 
	private String id;
	private String pw;
	private String name;
	private int age;
	private String phoneNumber;
	
	public USER_TBL_VO() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
