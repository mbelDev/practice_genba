package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "/index";
	}
	
	//URL수신
	@GetMapping("/main")
	public ModelAndView main(ModelAndView model) {
			
		//모델 작성
		ModelAndView mav = new ModelAndView();
		//경로 지정
		mav.setViewName("main");
		
		// 입력상자들 정보를 모델에 담음
		// 하단에 위치한 getInputItemList()메소드 주석 참조.
		mav.addObject("inputItemList",getInputItemList());
		// 선택지 정보를 모델에 담음
		mav.addObject("conditionList",getConditionList());
		// 개인적으로 쓴거
		mav.addObject("testList",getTestList());
		
		// 모델과 뷰를 리턴
		// 모델 앤 뷰 방식에서는 ModelAndView를 반환하는것으로 화면을 전환한다고합니다.
		return mav;
	}
	

	
	/*
	 *Controller가 복잡해지니까 데이터 작성하는 부분은 따로 메소드로 
	 *만들어서 뺐습니다.
	 *아마 현장에서는 이 부분을 ControllerHelper에서 Service같은걸로
	 *만들든지 받든지 해서 넘겨주지 않을까 싶네요.
	 */
		
	// 아이템 리스트를 생성
	public List<Map<String,String>>getInputItemList(){
		
		// 입력상자 데이터들(맵)을 담을 리스트
		List<Map<String,String>>inputItemList = new ArrayList<Map<String,String>>();
		// 각 입력상자들 상세 데이터(이름, 타입 등)가 담길 맵
		Map<String,String>inputItem = new HashMap<>();
		
		// 맵 초기화
		inputItem = new HashMap<>();
		inputItem.put("typeId","TEXT_BOX");     //뷰에서 typeId로 형식 결정
		inputItem.put("name","연습용 1번 상자");	//입력상자 이름
		// 리스트에 담음
		inputItemList.add(inputItem);

		inputItem = new HashMap<>();
		inputItem.put("typeId","TEXT_BOX");
		inputItem.put("name","연습용 2번 상자");

		inputItemList.add(inputItem);

		inputItem = new HashMap<>();
		inputItem.put("typeId","TEXT_BOX");
		inputItem.put("name","연습용 3번 상자");
		
		inputItemList.add(inputItem);
		
		inputItem = new HashMap<>();
		inputItem.put("typeId","CHECK_BOX");
		inputItem.put("name","연습용 1번 체크상자");
		
		inputItemList.add(inputItem);

		inputItem = new HashMap<>();
		inputItem.put("typeId","CHECK_BOX");
		inputItem.put("name","연습용 2번 체크상자");
		
		inputItemList.add(inputItem);
		
		inputItem = new HashMap<>();
		inputItem.put("typeId","COLOR");
		inputItem.put("name","연습용 색 선택 상자");
		
		inputItemList.add(inputItem);
		
		inputItem = new HashMap<>();
		inputItem.put("typeId","DROPDOWN_LIST");
		inputItem.put("name","장르");
		inputItem.put("listId", "GENRE"); // 선택항목 선정을 위해 id 부여
		
		inputItemList.add(inputItem);
		
		inputItem = new HashMap<>();
		inputItem.put("typeId","DROPDOWN_LIST");
		inputItem.put("name","직업");
		inputItem.put("listId", "JOB");
		
		inputItemList.add(inputItem);
		
		
		System.out.println("new List == "+inputItemList);
		
		// 리스트를 반환
		return inputItemList;
	}
	
	// 검색조건 리스트를 생성
	// 선택 가능한 입력상자 안에 들어갈 모든 내용들이 들어있습니다.
	// 어떤 상자에 들어갈지(ListId), 표시할 이름이 뭔지(name),
	// 실제 데이터 베이스에 어떤 이름으로 들어가는지(itemId)로 구성됩니다.
	public List<Map<String,String>>getConditionList(){
		
		// 선택지들을 담을 리스트
		List<Map<String,String>>conditionItemList = new ArrayList<Map<String,String>>();
		// 각 선택지들 상세 데이터(분류, 이름, 아이디 등)가 담길 맵
		Map<String,String>conditionItem = new HashMap<>();
		
		// 맵 초기화
		conditionItem = new HashMap<>();
		conditionItem.put("listId","GENRE");  // 선택지에 매칭시키기 위해 아이디 부여
		conditionItem.put("name","호러");	  // 뷰에 보여질 선택지 이름
		conditionItem.put("itemId","HORROR"); // 데이터 송신 시 실제로 전달될 값
		// 리스트에 담음
		conditionItemList.add(conditionItem);

		conditionItem = new HashMap<>();
		conditionItem.put("listId","GENRE");
		conditionItem.put("name","개그");
		conditionItem.put("itemId","GAG");

		conditionItemList.add(conditionItem);
				
		conditionItem = new HashMap<>();
		conditionItem.put("listId","GENRE");
		conditionItem.put("name","에로");
		conditionItem.put("itemId","ERROR");

		conditionItemList.add(conditionItem);
				
		conditionItem = new HashMap<>();
		conditionItem.put("listId","JOB");
		conditionItem.put("name","외국인 노동자");
		conditionItem.put("itemId","FORIGNER_LABOR");

		conditionItemList.add(conditionItem);
						
		conditionItem = new HashMap<>();
		conditionItem.put("listId","JOB");
		conditionItem.put("name","내국인 노동자");
		conditionItem.put("itemId","JAPANESE_LABOR");

		conditionItemList.add(conditionItem);
		
		conditionItem = new HashMap<>();
		conditionItem.put("listId","JOB");
		conditionItem.put("name","하세가와");
		conditionItem.put("itemId","HASEGAWA");

		conditionItemList.add(conditionItem);

		conditionItem = new HashMap<>();
		conditionItem.put("listId","JOB");
		conditionItem.put("name","금발 태닝 양아치");
		conditionItem.put("itemId","GOLDEN_TANNING_SHEEP_ARCH");

		conditionItemList.add(conditionItem);

		
		System.out.println("new List == "+conditionItemList);
		
		// 리스트를 반환
		return conditionItemList;
	}
	
	// 개인적으로 연습하던 데이터
	public List<Map<String,String>> getTestList(){
		List<Map<String,String>>testList = new ArrayList<Map<String,String>>();
		Map<String,String>testItem = new HashMap<String,String>();
		testItem.put("itemName", "test1");
		testItem.put("itemIOS", "1");
		testItem.put("itemAndroid", "0");
		
		testList.add(testItem);
		
		testItem = new HashMap<String,String>();
		testItem.put("itemName", "test2");
		testItem.put("itemIOS", "0");
		testItem.put("itemAndroid", "1");
		
		testList.add(testItem);
		
		testItem = new HashMap<String,String>();
		testItem.put("itemName", "test3");
		testItem.put("itemIOS", "1");
		testItem.put("itemAndroid", "1");
		
		testList.add(testItem);
		
		return testList;
	}
}
