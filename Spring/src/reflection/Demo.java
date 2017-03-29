package reflection;

public class Demo {
	private int age = 0;
	private String name;
	
	
	
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
