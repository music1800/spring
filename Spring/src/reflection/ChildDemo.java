package reflection;

import java.io.Serializable;

import com.ect.domain.User;

public class ChildDemo extends Demo<User, Serializable>{

	public ChildDemo(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}
	
}
