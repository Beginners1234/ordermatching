package businessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.Order;

public class TestOrderMatching {
	/*
	 * double orderId, String orderCategory, String orderType, Date orderTime, double orderQuantity,
			double orderPrice, double userId, String orderStatus, boolean aon
	 */

	@Test
	public void testOrderMatchingBuy() {
		System.out.println("in test buy");
		OrderMatching oms=new OrderMatching();
		Order buyorder=new Order(123, "buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		//Order sellorder=new Order(999, "sell", "limit", new Date(), 100, 20, 777, "pending", false);
		List<Order> sellerList=new ArrayList<Order>();
		sellerList.add(new Order(999, "sell", "limit", new Date(), 800, 152, 99, "PENDING", false));
		//sellerList.add(new Order(111, "sell", "limit", new Date(), 3000, 156, 11, "PENDING", false));
		//sellerList.add(new Order(222, "sell", "limit", new Date(), 100, 80, 22, "PENDING", false));
		System.out.println(buyorder+"\n"+"\n");
		oms.matchOrder(buyorder,sellerList,null);
	}
	
	//@Test
	public void testOrderMatchingSell() {

		System.out.println("in test sell");
		OrderMatching oms=new OrderMatching();
		Order sellorder=new Order(123, "sell", "limit", new Date(), 100, 40, 888, "PENDING", false);
		//Order sellorder=new Order(999, "sell", "limit", new Date(), 100, 20, 777, "pending", false);
		List<Order> buyerList=new ArrayList<Order>();
		buyerList.add(new Order(999, "buy", "limit", new Date(), 40, 60, 777, "PENDING", false));
		buyerList.add(new Order(999, "buy", "limit", new Date(), 30, 70, 777, "PENDING", false));
		System.out.println(sellorder+"\n"+"\n");
		oms.matchOrder(sellorder,null,buyerList);
	}

}
