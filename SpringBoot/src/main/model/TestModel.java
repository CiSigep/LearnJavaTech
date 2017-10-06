package main.model;

import org.springframework.stereotype.Component;

@Component
public class TestModel {
	
	private String test = "Here is a test model object for the view";
    private int value = 42;
    
	public String getTest() {
		return test;
	}
	public int getValue() {
		return value;
	}
    
    
    
}
