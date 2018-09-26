package businessLogic;

import java.util.List;
import java.util.Random;

import pojo.Order;

public class demo {
	


	public static void main(String[] args) {
//		RandomOrderGenerator r=new RandomOrderGenerator();
//		Thread t=new Thread(r);
//		t.setName("bob");
//		t.start();
		RandomOrderGenerator r=new RandomOrderGenerator();
	   List<Order>list=r.GeneraterandomOrderFinite(50);
	   for(Order i:list)
	   {
		   System.out.println(i);
	   }
		//r.GeneraterandomOrderInfinite();

}
}