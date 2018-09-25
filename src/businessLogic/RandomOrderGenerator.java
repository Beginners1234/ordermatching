package businessLogic;
import java.util.Random;

import pojo.Order;

public class RandomOrderGenerator implements Runnable {
	
	private Order Generate(double val, String type, String cat)
	{
		String order_cat = cat;
		String order_type = type;
		if(order_type == "buy")
		{
			double t=153+(val*2.3);
			double price=Math.round(t);
			Order o=new Order(0,order_cat,order_type, "na",0,price,1,"waiting");//id and time to be set when adding 
			return o;
		}
		else
		{
			double t=157+(val*2.3);
			double price=Math.round(t);
			Order o=new Order(0,order_cat,order_type, "na",0,price,1,"waiting");//id and time to be set when adding 
			return o;
		}
	}
//	
//	private Order GenerateBuy(double val, String type)
//	{
//		String order_type = type;
//		double t=153+(val*2.3);
//		double price=Math.round(t);
//		Order o=new Order(0,"limit",order_type, "na",0,price,1,"waiting");//id and time to be set when adding 
//		return o;
//	}
//	private Order GenerateSell(double val, String type)
//	{
//		String order_type = type;
//		double t=157+(val*2.3);
//		double price=Math.round(t);
//		Order o=new Order(0,"limit",order_type, "na",0,price,1,"waiting");//id and time to be set when adding 
//		return o;
//	}
	
	String[] o_type = {"buy", "sell"};
	int[] num = {2,5,4,3,8};
	String[] o_cat = {"limit", "market"};
	
	@Override
	public void run() {
		Random val_1=new Random(150);
		Random val_2=new Random(100);
		Random val_user=new Random(70);
		Random quantity=new Random(60);
		Random tim = new Random(40);
		Thread t=new Thread();
		while(true)
		{
			int o_t = new Random().nextInt(o_type.length);
			int o_c = new Random().nextInt(o_cat.length);
			
			double tim_step = tim.nextGaussian();
			
			if(Thread.currentThread().getName().equals("bob"))
			{
				try {
					Thread.sleep((long) (Math.abs(2000 + tim_step*2500)));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			double val_buy=val_1.nextGaussian();
			double val_sell=val_2.nextGaussian();
//			Order ob=GenerateBuy(val_buy, o_type[o_t]);
//			Order os=GenerateSell(val_sell, o_type[o_t]);
			double userId_buy =100+val_user.nextInt(10);
			double userId_sell=111+val_user.nextInt(10);
			double quant_buy=quantity.nextInt(100);
			double quant_sell=quantity.nextInt(100);
//			ob.setUserId(userId_buy);
//			os.setUserId(userId_sell);
//			ob.setOrderQuantity(quant_buy);
//			os.setOrderQuantity(quant_sell);
//			
			
			if(o_type[o_t] == "buy")
			{
				if(num[o_c] %2 == 0)
				{
					Order o = Generate(val_buy, o_type[o_t], o_cat[0]);
					o.setUserId(userId_buy);
					o.setOrderQuantity(quant_buy);
					System.out.println(o);
				}
				else
				{
					double pri = 99999;
					Order o = Generate(pri, o_type[o_t], o_cat[1]);
					o.setUserId(userId_buy);
					o.setOrderQuantity(quant_buy);
					System.out.println(o);
				}
			}
			else
			{
				if(num[o_c] %2 == 0)
				{
					Order o = Generate(val_sell, o_type[o_t], o_cat[0]);
					o.setUserId(userId_sell);
					o.setOrderQuantity(quant_sell);
					System.out.println(o);

				}
				else
				{
					double pri = -99999;
					Order o = Generate(pri, o_type[o_t], o_cat[1]);
					o.setUserId(userId_sell);
					o.setOrderQuantity(quant_sell);
					System.out.println(o);

				}

			}
			//call to place order function for os and ob
			//System.out.print(ob+"\t");System.out.print(os+"\n");  
		}

	}

}
