package com.koreait.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 테스트 코드가 스프링을 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록

@Log4j
public class SampleTests {

	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant; // 레스토랑을 출력하고 레스토랑 안에있는 쉐프를 출력해서 주입이 잘됬는지 확인

	@Test // 테스트를 위한 메소드라는 것을 표시해줘야한다.
	public void testExist() {
		assertNotNull(restaurant); // 해당 객체가 null이 아니여야만 테스트 성공

		log.info(restaurant);
		log.info("============");
		log.info(restaurant.getChef()); // 출력했을 때 주소그대로 나오지 않고 정리되어서 나온다.(toString())을 알아서 재정의 해준것

		/** 콘솔창 출력 결과
		 * INFO : com.koreait.sample.SampleTests - Restaurant(chef=Chef()) INFO :
		 * com.koreait.sample.SampleTests - ============ INFO :
		 * com.koreait.sample.SampleTests - Chef()
		 * 
		 * 1.테스트 코드가 실행되기 위해서 스프링 프레임워크가 동작
		 * 2. 동작하는 과정에서 필요한 객체들이 스프링에 등록
		 * 3. 의존성 주입이 필요한 객체는 자동으로 주입이 이루어짐
		 */
	}

}
