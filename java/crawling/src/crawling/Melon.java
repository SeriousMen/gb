package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//melon
public class Melon {
	//기본 셋팅 
	private WebDriver driver;
	private String url;	//들어갈 url을 담을 변수 설정 
	
	//사용할 웹드라이버 정보 입력 
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	//생성자를 활용해서 해당 클래스가 사용될 때 기본적인 세팅이 이루어지도록 설정 
	public Melon() {
		//드라이버 설정 : 해당 경로를 통하게 
		System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH); // 멜론키지마자 되게
		//크롬에 대한 옵션 설정 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless"); //소괄호 안에 "headless"를 넣어주면 실행중에 브라우저가 눈에 안보이게해준다.
		driver = new ChromeDriver(options); // 크롬 드라이버에 해당 옵션을 삽입(업캐스팅) 
		
		url = "https://www.melon.com/"; //내가 들어갈 url
		
		
	}
	/*우리가 할 것 
	 * url로 가서 상대방한테 입력받은 값을 입력창에 입력되게하고 엔터메소드로 브라우저에서 엔터가 쳐지게할것 
	그리고 곡명으로가서 10개를 가져온다. 그리고 몇 번을 선택할지 사용자가 고르고 고른 곡에서 가사 펼치기를 해서 가사를 출력해준다. 
	*/
	
	public void operate() {
		//드라이버 종료 / 여기서 searchSong 사용하고 종료
		
		searchSong();
		
		//실행되었다면 종료해줘라. 닫고 나가라. 
		try {if(driver != null){
			driver.close();
			driver.quit();
		}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	//태그를 객체로 보는 것이 익숙해져야 한다.
	//내가 원하는 태그를 정확히 가져오는 연습을 해야 앞으로 배울 Javascript도 쉽게 다룰 수 있다. 
	
	public void searchSong() {
		//메인 로직
		//노래 제목을 Scanner로 입력받고, 검색 결과를 뿌려준 후 사용자가 선택한 노래의 가사를 출력해준다.
		
		//1. 사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		//2. 입력한 값으로 검색(엔터)해준다.
		//※엔터 입력: 태그객체.sendKeys(Keys.RETURN); 
		//3. 검색 결과가 없다면 알맞는 메세지 출력
		//--> 만약 검색 결과가 없으면 exception이 발생한다. (NoSuchElementException) 자바 내부 API에도 이 Exception명이 있기 떄문에 
		// 셀레니움에 있는 NoSuchElementException를 잡아야 된다는 것을 명심
		//4. 사용자에게 검색된 곡 정보들을 출력해준다.(10개)
		//5. 사용자가 입력한 번호에 맞는 곡의 가사를 출력해준다.
		//6. 가사가 없거나 성인곡이라면 알맞는 메세지를 출력해준다. 
		
		Scanner sc = new Scanner(System.in);
		String searchMsg = "노래제목: ";
		String lyricNumMsg = "곡 번호: ";
		WebElement element = null;	//해당사이트에서 원하는 요소를 담을 WebElement 타입의 변수 선언 
		//변수의 재사용
		//장점: 메모리 효율, 절약
		//단점: 가독성이 떨어진다
		
		driver.get(url); // 해당 url로 접근 
		try {	Thread.sleep(1000);} catch (InterruptedException e) {;}
		//검색 창 태그 가져오기 : 해당 사이트에 있는 검색창태그를 가져와서 접근 
		element = driver.findElement(By.className("ui-autocomplete-input"));	
		
//		sc.next(); 이거 자체가 사용자가 입력한 문자열 값 
		
			
		//사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
		//1. 먼저 노래제목 입력하라고 콘솔창에 출력
		System.out.print(searchMsg);
		
		// sc.next() --> 엔터를 안먹음(버퍼에 엔터가 남아있다) sc.nextLine()엔터를 먹음(버퍼에 엔터가 안남아있다) 
		/**
		 * nextLine()과 next()메소드의 차이
		 * nextLine()메소드는 Enter를 치기 전까지의 문자열을 모두 리턴
		 * next()는 스페이스(공백) 전 까지 입력받은 문자열을 리턴 
		 */
		
		element.sendKeys(sc.nextLine());//노래 제목에 공백이 포함될 수 있기 때문에 nextLine()사용
		//엔터입력 
		element.sendKeys(Keys.RETURN);
		//검색 결과페이지 로딩 대기
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		//곡명으로 검색된 결과를 담고 있는 form태그 객체  frm_searchSong
		try {//첫번쨰 try문
			//해당 사이트에서 곡명안에 있는 태그들을 담는 form태그를 먼저 가져와서 그안에 있는 자식들을 불러온다. 매번 초기화 하지 않고 보다 간결하게 불러오기위해
			element =  driver.findElement(By.id("frm_searchSong"));//만약 frm_searchsong을 못찾는다면 없는 노래니까 catch문으로 
			//곡번호 가져오기
			List<WebElement> numList = element.findElements(By.className("no"));//해당 사이트에서 중복이 안되는 class명을 가져온다.
			
			//곡명 가져오기
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));
			
			//아티스트 가져오기(부모 div태그)
			List<WebElement> artistList = element.findElements(By.id("artistName"));//id를 통해
			//가져온 데이터를 통해 목록 출력
			for(int i=0; i< numList.size(); i++) {
				System.out.println(numList.get(i).getText()+"." 	
			+titleList.get(i).getText()+", 아티스트:"+artistList.get(i).getText());
				//get(i).getText() -> get(i)로 해당 요소에접근 .getText()로 그안의 Text를 리턴 
			}
			//번호 입력받기
			System.out.println(lyricNumMsg);
			int num = sc.nextInt();
			//입력한 번호에 가사보기 버튼 클릭(입력한 번호 -1번째 방의 가사 버튼) btn btn_icon_detail 태그안 클래스의 공백은 복수의 클래스 선언 
			element.findElements(By.className("btn_icon_detail")).get(num - 1).click(); //해당 인덱스요소를 클릭해라(
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			  try {
		            //가사 등록하기 버튼이 있다면  // 만약 찾지못하면(등록하기 버튼이 없다면, 가사가 있다면) 오류라서 catch로 이동
		            driver.findElement(By.className("d_register"));
		            //가사가 없는 곡이다.그래서 아래 출력해주고 try catch문 탈출
		            System.out.println("가사가 없는 곡입니다.");
		            
		         } catch (NoSuchElementException nsee) {
		            //가사 등록하기 버튼이 없다면 가사가 있는 곡이거나 성인 노래이다. 그래서 여기와서 아래 문장 실행 
		            //가사 펼치기 클릭 button_more
		            try {
		               //가사 펼치기가 있다면 해당 가사를 출력해준다.
		            	//먼저 클릭해서 펼쳐주고
		               driver.findElement(By.className("button_more")).click();
		               
		               try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		               
		               //가사 가져와서 출력하기
		               element = driver.findElement(By.className("lyric"));
		               System.out.println(element.getText());
		               
		            } catch (Exception e) {
		               //가사 펼치기 버튼이 없다면 성인 노래이다.
		               System.out.println("성인 노래 가사는 열람하실 수 없습니다.");
		            }
		         }
		      }//첫번째 try문 end
				catch (NoSuchElementException e) {//자바꺼말고 셀레니움 꺼 
		         System.out.println("검색 결과가 없습니다.");
		      }
	}
			
		
}

