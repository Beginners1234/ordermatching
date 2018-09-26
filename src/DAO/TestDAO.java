package DAO;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.Order;

public class TestDAO {
	OrderTableImpl o = new OrderTableImpl();
	@Test
	public void testAddOrder() {
		System.out.println("Test add order");
		Order order = new Order("buy", "limit", new Date(), 500, 155, 888, "pending", false);
//		Order order=new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		int ret=o.AddOrder(order);
		System.out.println("Return: "+ret);
	}
	
	@Test
	public void testDB() {
		
		List<Order> list=o.GetAllOrders();
		for(Order a:list) {
			System.out.println(a);
		}
	}
	
	//@Test
	public void test() {
		
		List<Order> list=o.GetOrderForMatching("sell",20.0);
		list.forEach(System.out::println);
	}

}
