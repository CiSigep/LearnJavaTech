package action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
	@Result(name = "index", location = "/WEB-INF/resource/page/index.jsp"),
	@Result(name = "input", location = "/WEB-INF/resource/page/input.jsp")
})
public class IndexAction extends ActionSupport {
	
	
	@Action(value = "/index")
	public String execute(){
		return "index";
	}
	
	@Action(value = "input")
	public String input(){
		return "input";
	}

}
