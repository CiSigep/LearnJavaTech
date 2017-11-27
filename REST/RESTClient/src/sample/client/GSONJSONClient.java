package sample.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import sample.data.Message;

public class GSONJSONClient implements JSONClient {
	
	Gson gson = new Gson();
	URL u;
	
    public GSONJSONClient(String url) throws Exception {
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
	    return gson.fromJson(sb.toString(), Message.class);
	
	}

	@Override
	public Message postMessage(Message msg) throws Exception {
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		
		String data = gson.toJson(msg);
		
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
		
		con.disconnect();
	    return gson.fromJson(sb.toString(), Message.class);
	}

}
