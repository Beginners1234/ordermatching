package businessLogic;

public class demo {
	
	public void change(int x)
	{x=5;}

	public static void main(String[] args) {
		RandomOrderGenerator r=new RandomOrderGenerator();
		Thread t=new Thread(r);
		t.setName("bob");
		t.start();

	}

}
