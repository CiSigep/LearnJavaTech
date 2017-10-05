package main.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.model.TestBean;
import main.model.TestModel;

@Controller
public class TestController {
	
	@Inject
	private TestBean test;
	@Inject
	private TestModel testm;
	
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
	
	@RequestMapping("/TESTMODEL")
	public String testModel(Model m){
		m.addAttribute("testm", testm);
		
		return "testModel";
	}
	
	@RequestMapping("/TESTREQUEST")
	public String testRequest(@RequestParam(value = "reqdata") String data, Model m){
		m.addAttribute("REQ", data);
		
		return "testRequest";
	}
	
	

}
