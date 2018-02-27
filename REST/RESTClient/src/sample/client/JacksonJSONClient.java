package sample.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import sample.client.JSONClient;
import sample.data.Message;

public class JacksonJSONClient implements JSONClient {
	
	private ObjectMapper ob;
	private ObjectReader or;
	private ObjectWriter ow;
	URL u;
	
	public JacksonJSONClient(String url) throws MalformedURLException {
		ob = new ObjectMapper();
		or = ob.readerFor(Message.class);
		ow = ob.writer();
		u = new URL(url);
	}

	@Override
	public Message getMessage() throws Exception {
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		
		con.disconnect();
		return or.readValue(sb.toString());
	}

	@Override
	public Message postMessage(Message msg) throws Exception {
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		
		String data = ow.writeValueAsString((msg));
		
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Content-Length", String.valueOf(data.length()));
		OutputStream os = con.getOutputStream();
		os.write(data.getBytes());
		os.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		
		return or.readValue(sb.toString());
	}

}
