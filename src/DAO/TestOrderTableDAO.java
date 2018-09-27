package DAO;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.Order;

public class TestOrderTableDAO {
	OrderTableImpl o = new OrderTableImpl();
	
	/*
	 * public int DropOrderTable();
	public List<Order> GetOrderByUserId(Double UserId);
	public List<Order> GetAllOrders(String status);
	public int AddOrder(Order order);
	public int GetCount();
	public List<Order> GetAllOrders();
	public List<Order> GetOrderForMatching(String order_category, Double quantity);
	public int UpdateOrderByOrderId(Order order);
	public int GetCountUser(double user_id);
	 */
	
	@Test
	public void testGetOrderByUserId() {
		List<Order> list=o.GetOrderByUserId(123.0,2);
		list.forEach(System.out::println);
		assert(list.get(0).getOrderId()==123.0);
	}
	
	@Test
	public void testGetAllOrdersWithStatus() {
		
		List<Order> list = o.GetAllOrders("Pending");
		list.forEach(System.out::println);
	}
	
	@Test
	public void testAddOrder() {
		System.out.println("Test add order");
		Order order = new Order("buy", "limit", new Date(), 80, 99, 10, "Pending", false);
		System.out.println(order);
		order=o.AddOrder(order);
		System.out.println("Return: "+order);
	}
	
	@Test	
	public void testGetCount() {
		
		int cou = o.GetCount();
		System.out.println(cou);

	}
	@Test
	public void testGetAllOrders() {

		List<Order> list=o.GetAllOrders();
		for(Order a:list) {
			System.out.println(a);
		}
	}
	
	@Test
	public void testGetOrderForMatching() {

		List<Order> list=o.GetOrderForMatching("buy",5);// put check for quantity vs total no of orders available
		list.forEach(System.out::println);
	}
	
	@Test 
	public void testUpdateOrderByOrderId() {
		
		Order order = new Order("buy", "limit", new Date(), 1000, 190, 1090, "rejected", true);
		order.setOrderId(61);
		int a = o.UpdateOrderByOrderId(order);
		System.out.println(a);
		
	}
	
	@Test
	public void testGetCountUser() {
		
		int a = o.GetCountUser(1002);
		System.out.println(a);
	}
}
