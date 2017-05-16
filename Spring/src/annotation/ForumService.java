package annotation;

import annotation.NeedTest;

public class ForumService{
	@NeedTest(true)
	public void deleteUser(int id) {
		System.out.println("delete user " + id);
	}
	
	@NeedTest(false)
	public void deletePass(int id) {
		System.out.println("delete pass " + id);
	}
}
