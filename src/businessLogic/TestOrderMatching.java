package businessLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import DAO.OrderTableImpl;
import pojo.Order;

public class TestOrderMatching {
	/*
	 * double orderId, String orderCategory, String orderType, Date orderTime, double orderQuantity,
			double orderPrice, double userId, String orderStatus, boolean aon
	 */
	
	@Test
	public void matchtest() {
		OrderMatching m=new OrderMatching();
		OrderTableImpl oimpl=new OrderTableImpl();
		System.out.println("Calling match from test");
		Order order= new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		order=oimpl.AddOrder(order);
		m.matchOrder( order);
		System.out.println("TTTTTTSSSST over");
	}

	@Test
	public void testGetStuff() {
		System.out.println("innnn");
		OrderTableImpl orderFunctions=new OrderTableImpl();
		
		Order order=new Order("buy", "limit", new Date(), 500, 155, 888, "COMPLETED", false);
		order.setOrderId(18.0);
		order.setRemaining_quantity(45.0);
		orderFunctions.UpdateOrderByOrderId(order);
		
//		Order buyorder=new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
//		List<Order> sellerList = orderFunctions.GetOrderForMatching("sell",20);
//		for(Order o:sellerList) {
//			System.out.println(o);
//		}
	}
	
	@Test
	public void addOrderstoDB() {
		OrderTableImpl orderFunctions=new OrderTableImpl();
		//Order buyorder=new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		orderFunctions.AddOrder(new Order("buy", "limit", new Date(), 80, 155, 888, "PENDING", false));
		orderFunctions.AddOrder(new Order("sell", "limit", new Date(), 10, 15,99, "PENDING", false));
		orderFunctions.AddOrder(new Order("sell", "limit", new Date(), 50, 10, 999, "PENDING", false));
	}
	
	//@Test
	public void testOrderMatchingBuy() {
		System.out.println("in test buy");
		OrderMatching oms=new OrderMatching();
		Order buyorder=new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		//Order sellorder=new Order(999, "sell", "limit", new Date(), 100, 20, 777, "pending", false);
		List<Order> sellerList=new ArrayList<Order>();
		sellerList.add(new Order("sell", "limit", new Date(), 800, 152, 99, "PENDING", false));
		//sellerList.add(new Order(111, "sell", "limit", new Date(), 3000, 156, 11, "PENDING", false));
		//sellerList.add(new Order(222, "sell", "limit", new Date(), 100, 80, 22, "PENDING", false));
		System.out.println(buyorder+"\n"+"\n");
		oms.matchOrder(buyorder,sellerList,null);
	}
	
	//@Test
	public void testOrderMatchingSell() {

		System.out.println("in test sell");
		OrderMatching oms=new OrderMatching();
		Order sellorder=new Order("sell", "limit", new Date(), 100, 40, 888, "PENDING", false);
		//Order sellorder=new Order(999, "sell", "limit", new Date(), 100, 20, 777, "pending", false);
		List<Order> buyerList=new ArrayList<Order>();
		buyerList.add(new Order("buy", "limit", new Date(), 40, 60, 777, "PENDING", false));
		buyerList.add(new Order("buy", "limit", new Date(), 30, 70, 777, "PENDING", false));
		System.out.println(sellorder+"\n"+"\n");
		oms.matchOrder(sellorder,null,buyerList);
	}

}
