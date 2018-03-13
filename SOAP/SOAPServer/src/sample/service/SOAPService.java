package sample.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SOAPService {
	
	@WebMethod
	public String hello(String input) {
		return "Hello, " + input;
	}

}
