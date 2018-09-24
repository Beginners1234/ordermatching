package DAO;

import java.util.List;

public interface OrderTable {
	public void DropOrderTable();
	public List GetOrderByUserId(String UserId);
	public List GetAllOrders(String status);
	public double AddOrder(Order order);

}
