package main.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	
	Logger log = LogManager.getLogger(TestAspect.class.getName());
	
	@Around("execution(public void main.model.TestAOPBean.access())")
	public void aroundTestAOP(ProceedingJoinPoint pjp) throws Throwable{
		log.info("Before");
		pjp.proceed();
		log.info("After");
		
	}

}
