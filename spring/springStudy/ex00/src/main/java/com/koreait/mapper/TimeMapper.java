package com.koreait.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	/**
	 * SQL이 복잡하거나 길어지는 경우에는 어노테이션보다는 XML을 이용하는 방식을 더 선호하게 된다.
	 * MyBatis-Spring의 경우 Mapper인터페이스와 XML을 동시에 이용할 수 있다.
	 */
	
//1.XML을 사용하지 않는 방법, @Select는 myBatis 어노테이션. 편리하다는 장점
	@Select("SELECT SYSDATE FROM DUAL") //이 어노테이션 안에 쿼리문의 실행 결과가 아래에 리턴된다.
	public String getTime(); //result 타입을 String으로 
	
//2. XML을 사용하는 방법 SQL이 길고 복잡해질 경우에 선호된다. SQL문은 src/main/resources의 com.koreait.mapper.TimeMapper.xml에 작성
	public String getTime2();
}
