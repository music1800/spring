package SpringAop;

public class WaiterImpl implements Waiter{

	@Override
	public void greetTo(String name) {
		// TODO Auto-generated method stub
		System.out.println("waiter greet to " + name + "...");
	}

	@Override
	public void serveTo(String name) {
		// TODO Auto-generated method stub
		System.out.println("waiter serve to " + name + "...");
	}

}
