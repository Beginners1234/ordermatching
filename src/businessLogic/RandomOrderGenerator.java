package businessLogic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import pojo.Order;

public class RandomOrderGenerator implements Runnable {
	//helper functions	
	static int seeder=0;
	private Order Generate(Random val, String type, String cat)
	{
		String order_cat = cat;
		String order_type = type;
		Date time_stamp= new Date();
		double val_w=val.nextGaussian();
		if(order_type == "buy")
		{
			double t=153+(val_w*2.3);
			double price=Math.round(t);
			while(price>160||price<150)//validity check
			{

				val_w=val.nextGaussian();
				t=153+(val_w*2.3);
				price=Math.round(t);
				
			}
			
	        
			Order o=new Order(order_type,order_cat,time_stamp,0,price,1,"pending",false);//id and time to be set when adding
			return o;

		}
		else
		{
			double t=157+(val_w*2.3);
			double price=Math.round(t);
			while(price>160||price<150)//validity check
			{

				val_w=val.nextGaussian();
				t=157+(val_w*2.3);
				price=Math.round(t);
				
			}
			//double price=Math.round(t);
			Order o=new Order(order_type,order_cat,time_stamp,0,price,1,"pending",false);//id and time to be set when adding 
			return o;
		}
	}
	
	//test generate order
	public List<Order> GeneraterandomOrderFinite(int numberOfOrders)
	{
		seeder=seeder+1;
		List<Order>listOfOrders=new ArrayList<>();
		String[] o_type = {"buy", "sell"};
		int[] num = {2,4,5,6,8};
		String[] o_cat = {"limit", "market"};
		Boolean[]o_aon= {true,false};
		int a_1=150;
		a_1=a_1+seeder;
		Random val_1=new Random(a_1);
		int b_1=100;
		b_1=b_1+seeder;
		Random val_2=new Random(b_1);
		int c_1=70;
		c_1=c_1+seeder;
		Random val_user=new Random(c_1);
		int d_1=700;
		d_1=d_1+seeder;
		Random quantity=new Random(d_1);
		int e_1=10;
		e_1=e_1+seeder;
		Random val=new Random(e_1);
		int f_1=91;
		f_1=f_1+seeder;
		Random g=new Random(f_1);
		for(int i=0;i<numberOfOrders;i++)
		{
			Boolean aon_random=o_aon[g.nextInt(2)];
			int o_t = new Random().nextInt(o_type.length);
			double userId_buy =100+val_user.nextInt(10);
			double userId_sell=111+val_user.nextInt(10);
			double quant_buy=1+quantity.nextInt(100);
			double quant_sell=1+quantity.nextInt(100);
			if(o_type[o_t] == "buy")
			{
				if(num[val.nextInt(5)] %2 == 0)
				{
					Order o = Generate(val_1, o_type[o_t], o_cat[0]);
					o.setUserId(userId_buy);
					o.setOrderQuantity(quant_buy);
					o.setAon(aon_random);
					o.setRemaining_quantity(quant_buy);
					listOfOrders.add(o);
					
				}
				else
				{
					double pri = 1000;
					Order o = Generate(val_1, o_type[o_t], o_cat[1]);
					o.setOrderPrice(pri);
					o.setUserId(userId_buy);
					o.setOrderQuantity(quant_buy);
					o.setRemaining_quantity(quant_buy);
					o.setAon(true);
					listOfOrders.add(o);
					
				}
			}
			else
			{
				if(num[val.nextInt(5)] %2 == 0)
				{
					Order o = Generate(val_2, o_type[o_t], o_cat[0]);
					o.setUserId(userId_sell);
					o.setOrderQuantity(quant_sell);
					o.setAon(aon_random);
					o.setRemaining_quantity(quant_sell);
					listOfOrders.add(o);

				}
				else
				{
					double pri = -1000;
					Order o = Generate(val_2, o_type[o_t], o_cat[1]);
					o.setUserId(userId_sell);
					o.setOrderQuantity(quant_sell);
                    o.setOrderPrice(pri);
                    o.setRemaining_quantity(quant_sell);
                    o.setAon(true);
					listOfOrders.add(o);
				}

			}
		}
		return listOfOrders;
		
	}
	//thread generate random orders infinite with time step
	public void GeneraterandomOrderInfinite(){
	String[] o_type = {"buy", "sell"};
	int[] num = {2,5,4,3,8};
	String[] o_cat = {"limit", "market"};
	Boolean[]o_aon= {true,false};
	Random val_1=new Random(150);
	Random val_2=new Random(100);
	Random val_user=new Random(70);
	Random quantity=new Random(60);
	Random tim = new Random(40);
	Random g=new Random(900);
	Thread t=new Thread();
	while(true)
	{
		Boolean aon_random=o_aon[g.nextInt(2)];
		int o_t = new Random().nextInt(o_type.length);
		int o_c = new Random().nextInt(5);
		
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
		double userId_buy =100+val_user.nextInt(10);
		double userId_sell=111+val_user.nextInt(10);
		double quant_buy=1+quantity.nextInt(100);
		double quant_sell=1+quantity.nextInt(100);
		if(o_type[o_t] == "buy")
		{
			if(num[o_c] %2 == 0)
			{
				Order o = Generate(val_1, o_type[o_t], o_cat[0]);
				o.setUserId(userId_buy);
				o.setOrderQuantity(quant_buy);
				o.setRemaining_quantity(quant_buy);
				o.setAon(aon_random);
				System.out.println(o);
				//call to place order function for o 
			}
			else
			{
				double pri = Double.MAX_VALUE;
				Order o = Generate(val_1, o_type[o_t], o_cat[1]);
				o.setUserId(userId_buy);
				o.setOrderQuantity(quant_buy);
				o.setRemaining_quantity(quant_buy);
				o.setOrderPrice(pri);
				o.setAon(true);
				System.out.println(o);
				//call to place order function for o 
			}
		}
		else
		{
			if(num[o_c] %2 == 0)
			{
				Order o = Generate(val_2, o_type[o_t], o_cat[0]);
				o.setUserId(userId_sell);
				o.setOrderQuantity(quant_sell);
				o.setRemaining_quantity(quant_sell);
				o.setAon(aon_random);
				System.out.println(o);
				//call to place order function for o 

			}
			else
			{
				double pri = -Double.MAX_VALUE;
				Order o = Generate(val_2,o_type[o_t], o_cat[1]);
				o.setUserId(userId_sell);
				o.setOrderQuantity(quant_sell);
				o.setRemaining_quantity(quant_sell);
				o.setOrderPrice(pri);
				o.setAon(true);
				System.out.println(o);
				
				//call to place order function for o 
			}

		}
	}

	
	}
	@Override
	public void run() {
		GeneraterandomOrderInfinite();
		}

	}


