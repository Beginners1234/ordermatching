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
	public void testOrderMatching() {
		System.out.println("in test");
		OrderMatching oms=new OrderMatching();
		Order buyorder=new Order(123, "buy", "limit", new Date(), 100, 40, 888, "pending", false);
		//Order sellorder=new Order(999, "sell", "limit", new Date(), 100, 20, 777, "pending", false);
		List<Order> sellerList=new ArrayList<Order>();
		sellerList.add(new Order(999, "sell", "limit", new Date(), 40, 20, 777, "pending", false));
		sellerList.add(new Order(999, "sell", "limit", new Date(), 30, 20, 777, "pending", false));
		System.out.println(buyorder+"\n"+"\n");
		oms.matchOrder(buyorder,sellerList);
	}

}
