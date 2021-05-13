package com.koreait.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller //자동으로 스프링의 객체(Bean)로 등록된다.
@RequestMapping("/sample/*") //만약에 경로에 sample이라는 요청이 있으면 다 일루와 //현재클래스의 모든 메소드들의 기본 경로 설정(이 앞전의 경로는 톰캣 서버 모듈에 등록된 path다.)
@Log4j
public class SampleController {
	
	@RequestMapping("") //아무것도 안치면 위에 처럼 다들어오는것  //GET, POST 상관없이 Controller 로직을 수행한다면 method 옵션을 사용하지 않는다.
	public void basic() { //void하면 요청한 것 그대로 나온다. ->sample.jsp
			log.info("basic.........");
	}
	
		//여러개 옵션을 쓸 때는 value를 써줘야한다. 이것은 GET방식으로만 앞에 URL을 요청했을 때
	@RequestMapping(value="/basic", method=RequestMethod.GET) //예를 들어 form태그의 메소드가 get방식으로 action됬을때만 온다. post방식일때는 안옴 
	public void basicGet() {
		log.info("basicGet.....");
	}
	
	//RequestMapping을 쓰는 이유는 여러가지 요청을 분기처리하기위해 get이나 post방식으로만 받을 거라면 아래처럼 GetMapping, PostMapping
	
	@GetMapping("/basicOnlyGet")//위처럼 method를 안하고 이렇게 getmapping으로 지정해서 get방식만 받을 수 있다.
	public void basicGet2() {
		log.info("basic get only get.....");
	}

	//Controller는 파라미터 타입에 따라 자동으로 매핑된다.
	
	@GetMapping("/ex01")//get방식이기 때문에 요청 주소 /ex01?뒤에 값을 넣을 수 있다. 
	//	http://localhost:8082/sample/ex01?name=김득구&&age=3 // servlet-context.xml에 등록을 했고 어노에티션으로 표식을 했기때문에 안에 있는 매개변수는 자동으로 객체로 등록해준다.
	//그래서 그냥 필드명을 써서 요청하면 된다.
	public String ex01(SampleDTO dto/*, Model model*/) { //객체는 앞에 대문자를 소문자로 해서 가져올 수 있기 때문에  Model객체가 필요없다.
		log.info(dto);
		//addAttribute(Object value)를 사용하면 해당 객체의 클래스타이에서 앞글자가 소문자로 바뀐 단어가 KEY가 된다.
		//model.addAttribute(dto);
		return "ex01"; // servlet-context의 viewResolver로 인해 접두 접미(.jsp)에 경로가 붙어서 리턴해준다. ex01.jsp의 출력문을 출력해준다.
	}
	
	//파라미터명이랑 DTO필드 명이랑 다를 때 원래 안들어가지 당연히 근데 @RequestParam()을 통해 해당 변수명으로 값을 전달했을 때 받아서 전달할 수 있다.
	@GetMapping("/ex02") //data1일때 name에 꽂아주고 data2로 넣을 때 age로 꽂아줘라
	public String ex02(@RequestParam("data1") String name, @RequestParam("data2") int age, Model model) {
		log.info("name : "+name);	//여기서는 model객체를 이용해야한다. 일반자료형은 화면에 전달이 안된다.(즉 출력이 안된다.)
		log.info("age : " + age);	
		model.addAttribute("name", name); //이렇게 담아서 넘겨줘야한다.
		model.addAttribute("age",age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas , Model model) {
		//http://localhost:8082/controller/sample/ex03?data=2,3,4,5 이런식으로 전달 
		log.info("datas:"+datas); //요청받는 값의 형태는 이렇게 인수의 타입대로 매핑해주는 듯하다.
		model.addAttribute("datas",datas);
		return "ex03";
	}
	
	
	
	//배열에 파라미터 담기
	@GetMapping("/ex04")
	public String ex04(@RequestParam("data2") String[] datas2, Model model) {
		log.info("datas2:"+Arrays.toString(datas2));
		model.addAttribute("data2",datas2);
		return "ex04";
	}
	
	//자동으로가게 model.addAttribute()가 아니라  @ModelAttribute()를 통해 바로
	@GetMapping("/ex05")
	public /*String*/ void ex05(SampleDTO dto, @ModelAttribute("gender") String gender2) {
		log.info(dto);					// @ModelAttribute()는 @RequestParam()의 역할도 하고(안에 선언된걸로 값을 받아야함) 안에 선언된 변수로 값을 model.addAttribute한다.
		log.info("gender2 :" + gender2);//@ModelAttribute는 자기가 매핑되서 받아온 값을 바로 jsp로 리턴해주는 듯하다. 여기 안에서 내부적으로 오른쪽에 선언된 인수에게 값을 전달하기는 한다.
										//다만 그 사용 범위가 지금 메소드 안인것 같다.
//		return "/sample/ex05";
	}
}
