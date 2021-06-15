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

public class NaverDict {
	private WebDriver driver;
	private String url;
	
	public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
	
	public NaverDict() {
		System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://en.dict.naver.com/";
		
		
	}
	
	

	public void operate() {
		
		
		searchWord();
		try {if(driver != null){
			
			driver.close();
			driver.quit();
		}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void searchWord() {
		Scanner sc = new Scanner(System.in);
		
		String searchMsg = "단어이름: ";
		WebElement element = null;
	
		driver.get(url);

		element = driver.findElement(By.id("ac_input"));	
		System.out.println("원하시는 영어단어를 입력하면 예문을 찾아드립니다.");
		System.out.print(searchMsg);		
		element.sendKeys(sc.nextLine());	 
		element.sendKeys(Keys.RETURN);
		try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		
		
		try {
			element = driver.findElement(By.id("searchPage_example_more"));	
			element.click();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
			
			
//			element = driver.findElement(By.className("component_example has-saving-function")); Q.이걸거치면 왜 안되는 걸까?
			
				
				List<WebElement> dictList = driver.findElements(By.className("text"));
				
				for(int i=0; i< dictList.size(); i++) {
					System.out.println(dictList.get(i).getText());
				}
		} catch (NoSuchElementException e) {
			System.out.println("없는단어 입니다. 다시 입력해주세요.");
			
		}
			
			
				
	
	}
	
	public static void main(String[] args) {
		NaverDict nd = new NaverDict();
		nd.operate();
	}
}




