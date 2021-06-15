package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CGV {	
	private WebDriver driver;
	private WebElement el;
	
	//기본 셋팅
	//chrome 드라이버가 위치한 경로를 적어준다. 
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public static void main(String[] args) {
		CGV cgv = new CGV();
		WebElement el1 = null;
		WebElement el2 = null;
		
		//드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//WebDriver 옵션설정
		
		//1.옵션 있을 때
		ChromeOptions options = new ChromeOptions();	//크롬에 대한 옵션 설정	
		options.addArguments("headless"); // "headless"를 넣어주면 브라우저가 눈에 안보이게 된다. 
		cgv.driver = new ChromeDriver(options);	// 크롬 드라이버에 옵션 삽입 //WebDriver(부모)에 ChromeDriver(자식)넣어으니 업캐스팅 
		
		//2.옵션 없을 때
//		cgv.driver = new ChromeDriver();
		
		String url = "http://www.cgv.co.kr/movies/"; // 내가 들어갈 url을 설정 
		
		cgv.driver.get(url); // 전달한 url로 가고나서 시작하게된다.(크롤링할 사이트를 알려준다.)
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {}//실행을 하고 기다려야되기때문에 1초정도 기다려주도록 해준다.
		//브라우저의 응답 속도보다 컴파일 속도가 더 빠르기 때문에 sleep을 해주는 것 (기다리기 위해)
//		btn-more-fontbold
		el1 = cgv.driver.findElement(By.className("btn-more-fontbold"));// 이 통채로가 더보기 버튼이다. 값을 el1에 담아준다.
		
		//동적 : 더보기 버튼을 클릭하는것 , 그냥 가져오는 것은 정적 
		el1.click(); // 이러면 위의 버튼이 클릭이 된다. 
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
//		sect-movie-chart 모든 영화목록을 가지고 있는 div태그
		el2 = cgv.driver.findElement(By.className("sect-movie-chart"));
		
		int rank = 0; 
		//가져온 태그 안에 찾을 자식 태그가 있다면 또 한번 findElement()를 사용할 수 있다.
	for(WebElement film : el2.findElements(By.className("title"))) {
		System.out.println(++rank+ "."+film.getText());//title이란 클래스 이름이 복수니까 findElements
	}
	
		// 닫을 때 try catch를 해줘야 한다. 

}
	}
	

