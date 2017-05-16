package SpringAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspectj {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting(){
		System.out.println("How you doing ");
	}
}
