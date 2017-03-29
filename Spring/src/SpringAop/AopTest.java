package SpringAop;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	String configPath ;
	 ApplicationContext context ;
	
	@Before
	public void init(){
		 configPath = "applicationContext.xml";
		 context = new ClassPathXmlApplicationContext(configPath);
	}

	@Test
	public void test() {
		ForumServiceInterface service = new ForumService();
		service.deleteUser(123);
	}
	
	@Test
	public void testJdk(){
		ForumServiceInterface service = new ForumService();
		PerformanceHandler handler = new PerformanceHandler(service);
		ForumServiceInterface proxy = (ForumServiceInterface) Proxy.newProxyInstance(
				service.getClass().getClassLoader(),
				service.getClass().getInterfaces(),
				handler);
		proxy.deleteUser(123);
	}
	
	@Test
	public void testCglib(){
		CglibProxy proxy = new CglibProxy();
		ForumServiceInterface serviceInterface = (ForumServiceInterface)proxy.getProxy(ForumService.class);
		serviceInterface.deleteUser(321);
	}
	
	@Test
	public void testBeforeAdvice(){
		Waiter target = new NativeWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		ProxyFactory pf = new ProxyFactory();
		
		pf.setTarget(target);
		pf.addAdvice(advice);
		Waiter waiter = (Waiter)pf.getProxy();
		
		waiter.greetTo("LiGen");
		
	}
	
	@Test
	public void testAopConfig(){
		Waiter waiter = (Waiter)context.getBean("waiter");
		waiter.greetTo("LG");
	}
	
	@Test
	public void testAopAdvisor(){
		WaiterImpl waiterImpl = (WaiterImpl)context.getBean("waiter");
		Seller seller = (Seller)context.getBean("seller");
		waiterImpl.greetTo("LeeGen");
		waiterImpl.serveTo("LeeGen");
		//seller.greetTo("Ligen");
	}
	
	@Test
	public void testAopRegexp(){
		
	}

}
