package businessLogic;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.Order;

public class TestOrderProcessInterfaceImpl {

	OrderProcessesInterfaceImpl op = new OrderProcessesInterfaceImpl();

	@Test
	public void viewOrders1()
	{
		List<Order> list = op.viewOrders();
		for(Order a:list) {
			System.out.println(a);
		} 	
	}
	
	@Test
	public void viewOrders2()
	{
		List<Order> list = op.viewOrders("PENDING");
		for(Order a:list) {
			System.out.println(a);
		}
		
	}
	
	@Test
	public void viewOrders3()
	{
		List<Order> list = op.viewOrders(123.0, 2);
		for(Order a:list) {
			System.out.println(a);
		}
	}
	
	@Test
	public void PlaceOrder()
	{
		System.out.println("Hello");
		Order order = new Order("buy", "limit", new Date(), 100, 90, 90, "PENDING", true);
		System.out.println(order);
		int n = op.PlaceOrder(order);
		System.out.println(n);
		
	}
	
	@Test
	public void GetStatistics()
	{
		int count = op.GetStatistics("order");
		System.out.println(count);
	}
	
	@Test
	public void GetStatisticsUser()
	{
		int count = op.GetStatisticsUser(123.0, "order");
		System.out.println(count);
	}
}
