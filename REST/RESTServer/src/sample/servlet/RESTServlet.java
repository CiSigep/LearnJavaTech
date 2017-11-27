package sample.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import sample.data.Message;

public class RESTServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ObjectMapper ob = new ObjectMapper();
	private ObjectReader or = ob.readerFor(Message.class);
	private ObjectWriter ow  = ob.writer();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Message msg = new Message();
		
		msg.setMsg("Hello Client");
		
		resp.getWriter().write(ow.writeValueAsString(msg));
		resp.setContentType("application/json");
		resp.flushBuffer();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		
		String line;
		while((line = br.readLine()) != null)
			sb.append(line);
		
		Message rec = or.readValue(sb.toString());
		
		Message ms = new Message();
		ms.setMsg("Your Message: " + rec.getMsg());
		
		resp.getWriter().write(ow.writeValueAsString(ms));
		resp.setContentType("application/json");
		resp.flushBuffer();
	}
	
	

}
