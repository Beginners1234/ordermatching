package businessLogic;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	   List<Order>list=r.GeneraterandomOrderFinite(500);
	  // List<Order>list2=r.GeneraterandomOrderFinite(500);
        OrderTableImpl ot=new OrderTableImpl();
        for(int i=0;i<500;i++)
        {
        	Order b=list.get(i);
        	//Order c=list2.get(i);
        	//System.out.println(b.getOrderTime());
        	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(b.getOrderTime()));
        	
        	//ot.AddOrder(b);
        }
}
}