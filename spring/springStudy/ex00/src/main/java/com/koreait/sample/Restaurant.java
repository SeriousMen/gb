package com.koreait.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

/*②*/
@Component	//모델 객체에만 Component를 쓴다.(스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션이다.)//소괄호안에 id를 부여할 수도있음)
@Data //Lombok이 자동으로 getter/setter, 생성자, toString()을 만들어준다.
public class Restaurant {
	//Chef에 의존하는 Restaurant를 만들자
	
//private Chef chef = new Chef(); 이렇게 안하게 하려고 의존성 주입을 한다.
	
	/**
	 * @Setter에 사용된 onMethod 속성은 생성되는 setChef에 @Autowired 어노테이션을 추가하도록 해서 
	 * Lombok으로 생성된 클래스에 대한 정보를 이클립스를 통해 확인할 수 있다.
	 * 버전에 따라 onMethod 혹은 onMethod_를 사용하게 된다.
	 *  @Autowired는 xml파일에서 bean요소 안에있는 property와 같은 기능을 한다.
	 *  @Autowired는 1.필드(기본생성자) 2.오버로드생성자 3.set메소드(일반적으로 set메소드)에 선언 가능
	 *  만약 Ioc컨테이너에 bean이 동명으로 선언되있거나 복수가 동일객체를 지목해 autowire하기 관란할 경우 @Qualifier(사용할 bean id)를 활용하면된다.
	 */
	/*③*/
	@Setter(onMethod_ = @Autowired)
	private Chef chef;	//필드(기본생성자)
	
}
