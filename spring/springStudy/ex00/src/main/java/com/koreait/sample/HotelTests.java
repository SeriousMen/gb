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

//자동으로 만들어줄 애플리케이션 컨텍스트의 설정 파일의 위치를 지정할 때 사용 //지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 

@Log4j
public class HotelTests {
	@Setter(onMethod_ =@Autowired)
	private Hotel hotel;
	
	@Test
	public void testExist() {
		assertNotNull(hotel); //assertNotNull(객체) : // 해당 객체가 null이 아니여야만 테스트 성공 null이면 아래 출력안됨
					//이게 없으면 null이여도 아래 출력됨
		
		
		log.info(hotel);
		log.info("========");
		log.info(hotel.getChef());
	}

}
