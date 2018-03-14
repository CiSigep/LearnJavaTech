package sample;

import sample.client.GSONJSONClient;
import sample.client.JSONClient;
import sample.client.JacksonJSONClient;
import sample.client.JerseyJSONClient;
import sample.data.Message;

public class Main {
	
	public static void main(String args[]) throws Exception{
		JSONClient jc = null;
		//jc = new GSONJSONClient("http://localhost:7001/RESTServer/api");
		//jc = new JerseyJSONClient("http://localhost:7001/RESTServer/api");
		jc = new JacksonJSONClient("http://localhost:7001/RESTServer/api");
		
		Message m = jc.getMessage();
		
		System.out.println(m.getMsg());
		System.out.println(m.getMli().size() + ": " + m.getMli().get(0).getItem());
		
		Message send = new Message();
		send.setMsg("Hi from client");
		
		Message rec = jc.postMessage(send);
		System.out.println(rec.getMsg());
		System.out.println(rec.getMli().size() + ": " + rec.getMli().get(0).getItem());
		System.out.println(rec.getMli().get(1).getItem());
		
		System.out.println(rec.getMsg());
		
	}

}
