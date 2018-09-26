package businessLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pojo.Order;

public interface OrderProcessesInterface {
	public List<Order> viewOrders(String status);
	public List<Order> viewOrders(double userId);
	public List<Order> viewOrders();

	
}
