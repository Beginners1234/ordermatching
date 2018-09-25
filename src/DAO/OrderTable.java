package DAO;

import java.util.List;

import pojo.Order;

public interface OrderTable {
	public double DropOrderTable();
	public List GetOrderByUserId(Double UserId);
	public List GetAllOrders(String status);
	public double AddOrder(Order order);
	public List GetAllOrders();

}