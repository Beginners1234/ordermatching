package businessLogic;

import java.util.List;

import pojo.Order;

public interface OrderProcessesInterface {
	public List<Order> viewOrders(String status);
	public List<Order> viewOrders(double userId, int quantity);
	public List<Order> viewOrders();
	public int PlaceOrder(Order order);
	public int GetStatistics(String cat);
	public int GetStatisticsUser(double user_id, String cat);
	public String GetStatisticsUser(double user_id);
}
