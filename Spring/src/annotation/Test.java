package annotation;

import java.lang.reflect.Method;

public class Test {
	
	@org.junit.Test
	public void testAnnotataion(){
		Class clazz = ForumService.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			NeedTest nTest = method.getAnnotation(NeedTest.class);
			if (nTest != null) {
				if(nTest.value()){
					System.out.println(method.getName() + "() need test");
				}else {
					System.out.println(method.getName() + "() not need test");
				}
			}
		}
	}
}
