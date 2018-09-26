package DAO;

import java.util.List;

import pojo.Order;

public interface OrderTable {
	public int DropOrderTable();
	public List<Order> GetOrderByUserId(Double UserId, int quantity);
	public List<Order> GetAllOrders(String status);
	public int AddOrder(Order order);
	public int GetCount();
	public List<Order> GetAllOrders();
	public List<Order> GetOrderForMatching(String order_category, Double quantity);
	public int UpdateOrderByOrderId(Order order);
	public int GetCountUser(double user_id);
}

