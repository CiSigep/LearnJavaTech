package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequestMapping(value="/main", method=RequestMethod.GET)
public class EventController {
	
	private int visits = 0;
	
	@RequestMapping(value="/visit", method=RequestMethod.GET)
	public String visit(ModelMap model)
	{
		visits++;
		model.addAttribute("visits", visits);
		return "visits";
	}
	
	
	@RequestMapping("/event")
	public SseEmitter showVisits(HttpServletRequest req) throws IOException
	{
		SseEmitter emit = new SseEmitter();
		
		emit.send(visits + "");
		
		emit.complete();
		
		return emit;
	}
	

	

}
