package DAO;

import java.util.List;

import pojo.Order;

public interface OrderTable {
	public double DropOrderTable();
	public List<Order> GetOrderByUserId(Double UserId);
	public List<Order> GetAllOrders(String status);
	public double AddOrder(Order order);
	public double GetCount();
	public List<Order> GetAllOrders();
	public List<Order> GetOrderForMatching(String order_category, Double quantity);
	public double UpdateOrderByOrderId(Order order);
}

