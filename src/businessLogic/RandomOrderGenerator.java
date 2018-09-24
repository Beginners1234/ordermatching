package businessLogic;
import java.util.Random;

import com.pojo.Order;

public class RandomOrderGenerator implements Runnable {
	private Order GenerateBuy(double val)
	{
		double t=153+(val*2.3);
		double price=Math.round(t);
		Order o=new Order(0,"limit","buy", "na",0,price,1,"waiting");//id and time to be set when adding 
		return o;
	}
	private Order GenerateSell(double val)
	{
		double t=157+(val*2.3);
		double price=Math.round(t);
		Order o=new Order(0,"limit","sell", "na",0,price,1,"waiting");//id and time to be set when adding 
		return o;
	}
	@Override
	public void run() {
		Random val_1=new Random(150);
		Random val_2=new Random(100);
		Random val_user=new Random(70);
		Random quantity=new Random(60);
		Thread t=new Thread();
		while(true)
		{
			if(Thread.currentThread().getName().equals("bob"))
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			double val_buy=val_1.nextGaussian();
			double val_sell=val_2.nextGaussian();
			Order ob=GenerateBuy(val_buy);
			Order os=GenerateSell(val_sell);
			double userId_buy =100+val_user.nextInt(10);
			double userId_sell=111+val_user.nextInt(10);
			double quant_buy=quantity.nextInt(100);
			double quant_sell=quantity.nextInt(100);
			ob.setUserId(userId_buy);
			os.setUserId(userId_sell);
			ob.setOrderQuantity(quant_buy);
			os.setOrderQuantity(quant_sell);
			//call to place order function for os and ob
			System.out.print(ob+"\t");System.out.print(os+"\n");  
		}

	}

}
