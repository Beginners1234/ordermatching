package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DAO.OrderTableImpl;
import pojo.Order;

public class OrderProcessesInterfaceImpl implements OrderProcessesInterface{
    
	OrderTableImpl o=new OrderTableImpl();
	@Override
	public List<Order> viewOrders(String status) {
	
		return o.GetAllOrders(status);
	}

	@Override
	public List<Order> viewOrders(double userId) {
		return o.GetOrderByUserId(userId);
	}

	@Override
	public List<Order> viewOrders() {
		return o.GetAllOrders();
	}
	

}
