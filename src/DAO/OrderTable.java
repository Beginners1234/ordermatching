package DAO;

import java.util.List;

import pojo.Order;

public interface OrderTable {
	public void DropOrderTable();
	public List GetOrderByUserId(String UserId);
	public List GetAllOrders(String status);
	public double AddOrder(Order order);

}
