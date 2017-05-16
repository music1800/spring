package reflection;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.ect.utils.GetSuperClassGenricType;

public abstract class Demo <T, PK extends Serializable> {
	
	
	public Demo(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("getClass():"+getClass().getName());
		entityClass = GetSuperClassGenricType.getSuperClassGenricType(getClass(), 0);
		
		System.out.println("entityClass:"+entityClass);
	}
	
	private int age = 0;
	private String name;
	protected Class<T> entityClass;
	
	
	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String toString(){
		return "Demo:  [age:" + age + "],[name:" + name + "]";
	}
	
	
}
