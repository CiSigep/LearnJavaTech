package sample.client;

import sample.data.Message;

public interface JSONClient {
	
	public Message getMessage() throws Exception;
	
	public Message postMessage(Message msg) throws Exception;

}
