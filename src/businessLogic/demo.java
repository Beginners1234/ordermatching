package businessLogic;

import java.util.Date;
import java.util.List;
import java.util.Random;

import DAO.OrderTableImpl;
import pojo.Order;

public class demo {
	


	public static void main(String[] args) {
//		RandomOrderGenerator r=new RandomOrderGenerator();
//		Thread t=new Thread(r);
//		t.setName("bob");
//		t.start();
		RandomOrderGenerator r=new RandomOrderGenerator();
	   List<Order>list=r.GeneraterandomOrderFinite(50);
	   List<Order>list2=r.GeneraterandomOrderFinite(50);
        OrderTableImpl ot=new OrderTableImpl();
        for(int i=0;i<50;i++)
        {
        	Order b=list.get(i);
        	Order c=list2.get(i);
        	System.out.println(b);
        	
        	ot.AddOrder(b);
        }
}
}