package SpringAop;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;


public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean matches(Method method, Class<?> clazz) {
		
		return "greetTo".equals(method.getName());
	}
	
	public ClassFilter getClassFilter(){
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				return WaiterImpl.class.isAssignableFrom(clazz);
			}
		};
	}

}
