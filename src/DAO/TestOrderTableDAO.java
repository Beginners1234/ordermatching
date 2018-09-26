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

	}
	@Test
	public void testGetAllOrdersWithStatus() {

	}
	@Test
	public void testGetAddOrder() {
		System.out.println("Test add order");
		Order order = new Order("buy", "limit", new Date(), 500, 155, 888, "pending", false);
//		Order order=new Order("buy", "limit", new Date(), 500, 155, 888, "PENDING", false);
		int ret=o.AddOrder(order);
		System.out.println("Return: "+ret);
	}
	@Test
	public void testGetCount() {

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

		List<Order> list=o.GetOrderForMatching("sell",20.0);
		list.forEach(System.out::println);
	}
	@Test
	public void testUpdateOrderByOrderId() {

	}
	@Test
	public void testGetCountUser() {

	}




}
