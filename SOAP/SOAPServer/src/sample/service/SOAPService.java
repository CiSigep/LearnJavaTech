package sample.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sample.data.Message;

@WebService
public class SOAPService {
	
	@WebMethod
	public Message hello(Message input) {
		return new Message("Hello, " + input.getMsg());
	}

}
