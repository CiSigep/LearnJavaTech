package main.model;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
	
	private String test = "I am a Test Bean";
	
	public String getTest(){ return test; }

}
