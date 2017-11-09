package action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import data.Input;


@Result(name = "output", location = "/WEB-INF/resource/page/output.jsp")
public class OutputAction extends ActionSupport{
	
	private Input input;
	
	@Action(value = "/output")
	public String execute(){
		return "output";
		//return "input";
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	

}
