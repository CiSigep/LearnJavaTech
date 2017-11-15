package interceptors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CustomInterceptor implements Interceptor {
	
	private static Logger log = LogManager.getLogger(CustomInterceptor.class.getName());

	@Override
	public void destroy() {
		log.info("CustomInterceptor Destroyed");
	}

	@Override
	public void init() {
		log.info("CustomInterceptor Initialized");
	}

	@Override
	public String intercept(ActionInvocation act) throws Exception {
		log.info("Interception started, invoking action");
		
		String result = act.invoke();
		
		log.info("Action completed, completing intercept");
		
		return result;
	}

}
