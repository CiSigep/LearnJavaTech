package main.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	
	@Around("execution(public void main.model.TestAOPBean.access())")
	public void aroundTestAOP(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Before");
		pjp.proceed();
		System.out.println("After");
		
	}

}
