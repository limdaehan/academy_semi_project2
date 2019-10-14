package lx.edu.semi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

	@Before("execution(* lx.edu.ex04.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("logBefore()");
	}
}
