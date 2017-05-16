package com.ect.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.FileDataSource;

import org.junit.Test;

import SpringAop.ForumService;
import SpringAop.ForumServiceInterface;
import SpringAop.PerformanceHandler;
import reflection.ChildDemo;
import reflection.Demo;

public class ForTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws ParseException {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//			//Date date = new Date("20161205234258");
//			String str = "20161205234258";
//			char[] dateChar = str.toCharArray();
//			StringBuilder sBuilder = new StringBuilder();
//			for(int i = 0 ; i < dateChar.length ; i++){
//				sBuilder.append(dateChar[i]);
//				if(i == 3){
//					sBuilder.append('-');
//				}else if (i == 5){
//					sBuilder.append('-');
//				}else if (i == 7){
//					sBuilder.append(' ');
//				}else if (i == 9){
//					sBuilder.append(':');
//				}else if (i == 11){
//					sBuilder.append(':');
//				}
//			}
		
		String str = "2017-03-21 17:48:18";
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(formatter.parse(str));
	}
	
	@Test
	public void testReflection() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException{
		Class<?> myClass = Demo.class;
		System.out.println("myClass: " + myClass.getName());
		
//		Field[] fields = myClass.getDeclaredFields();
//		for(Field f : fields){
//			System.out.println(f.getName() + ":" + f.getType());
//		}
//		
//		java.lang.reflect.Method[] methods =  myClass.getDeclaredMethods();
//		for(java.lang.reflect.Method m : methods){
//			System.out.println(m);
//		}
		
		
		Demo demo  = (Demo) myClass.newInstance();
		
		Method method = myClass.getMethod("setAge", int.class);
		try {
			method.invoke(demo,100);
			
			Method method2 = myClass.getMethod("getAge");
			System.out.println(demo);
			
			
			
			
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testAop(){
		ForumServiceInterface service = new ForumService();
		//service.deleteUser(0);
		PerformanceHandler handler = new PerformanceHandler(service);
		ForumServiceInterface proxy = (ForumServiceInterface) Proxy.newProxyInstance(
				service.getClass().getClassLoader(),
				service.getClass().getInterfaces(),
				handler);
		try {
			proxy.deleteUser(123);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void Ref(){
		ChildDemo demo = new ChildDemo(12,"212");
	}
	

}
