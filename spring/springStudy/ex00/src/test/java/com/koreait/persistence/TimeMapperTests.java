package com.koreait.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 테스트 코드가 스프링을 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록

@Log4j
public class TimeMapperTests {

	@Setter(onMethod_= @Autowired)//TimeMapper의 인터페이스를 DI하고 
	private TimeMapper timeMapper;
	
	
	@Test
	public void testGetTime() { //TimeMapper.java에 있는 어노에티션을 이용한 쿼리문이 실행된 리턴 값을 출력.
		log.info(timeMapper.getTime());
	}
	
	/**
	 * MyBatis는 내부적으로 JDBC의 PreparedStatement를 이용해서 SQL을 처리한다.
	 * 따라서 SQL에 전달되는 파라미터는 JDBC에서와 같이'?'로 치환되어 처리된다.
	 * 복잡한 SQL의 경우 '?'로 나오는 값이 제대로 되었는지 확인하기 쉽지 않고 실행된 SQL의
	 * 내용을 정확히 확인하기 어렵기 때문에 log4jdbc-log4j2라이브러리를 사용하여 어떤 값인지를 
	 * 정확히 확인한다.
	 */

		@Test
	public void testGetTime2() {//실행하면 timeMapper에 선언되있는 메소드와 동명의 namespace를 가진 xml이 실핸된다.
		log.info(timeMapper.getTime2());
	}
}
