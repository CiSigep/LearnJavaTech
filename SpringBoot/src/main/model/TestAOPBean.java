package main.model;

import org.springframework.stereotype.Component;

@Component
public class TestAOPBean {
	
	private String accessed = "I was accessed.";
	
	public void access(){
		System.out.println(accessed);
	}

}
