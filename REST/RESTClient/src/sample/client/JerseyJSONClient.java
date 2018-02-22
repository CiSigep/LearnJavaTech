package sample.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import sample.data.Message;

public class JerseyJSONClient implements JSONClient {

	private String uri;
	
	public JerseyJSONClient(String uri) {
		this.uri = uri;
	}
	
	@Override
	public Message getMessage() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget wt = client.target(uri);
		
		Invocation.Builder b = wt.request(MediaType.APPLICATION_JSON);
		
		return b.get(Message.class);
	}

	@Override
	public Message postMessage(Message msg) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget wt = client.target(uri);
		
		Invocation.Builder b = wt.request(MediaType.APPLICATION_JSON);
		
        return b.post(Entity.entity(msg, MediaType.APPLICATION_JSON)).readEntity(Message.class);
	}

}
