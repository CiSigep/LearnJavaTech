package sample;

import sample.client.GSONJSONClient;
import sample.data.Message;

public class Main {
	
	public static void main(String args[]) throws Exception{
		GSONJSONClient gjc = new GSONJSONClient("http://localhost:7001/RESTServer/api");
		
		Message m = gjc.getMessage();
		
		System.out.println(m.getMsg());
		
		Message send = new Message();
		send.setMsg("Hi from client");
		
		Message rec = gjc.postMessage(send);
		
		System.out.println(rec.getMsg());
		
	}

}
