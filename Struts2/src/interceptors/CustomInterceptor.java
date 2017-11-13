package interceptors;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CustomInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("CustomInterceptor Destroyed");
	}

	@Override
	public void init() {
		System.out.println("CustomInterceptor Initialized");
	}

	@Override
	public String intercept(ActionInvocation act) throws Exception {
		System.out.println("Interception started, invoking action");
		
		String result = act.invoke();
		
		System.out.println("Action completed, completing intercept");
		
		return result;
	}

}
