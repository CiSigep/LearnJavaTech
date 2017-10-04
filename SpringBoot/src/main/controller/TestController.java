package main.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.model.TestBean;

@Controller
public class TestController {
	
	@Inject
	private TestBean test;
	
	@RequestMapping("/TEST")
	@ResponseBody
	public String test(){
		return "I AM A TEST RESPONSE";
	}
	
	@RequestMapping("/TESTBEAN")
	@ResponseBody
	public String testBean(){
		return test.getTest();
	}
	
	@RequestMapping("/TESTPAGE")
	public String testPage(){
		return "testFile";
	}

}
