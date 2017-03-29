package SpringAop;

public class ForumService implements ForumServiceInterface{
	public void deleteUser(int id) {
		//PerformanceMonitor.begin("deleteUser");
		try {
			Thread.currentThread().sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PerformanceMonitor.end();
	}
}
