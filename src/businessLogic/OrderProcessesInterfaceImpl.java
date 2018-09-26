package businessLogic;

import java.util.ArrayList;
import java.util.List;

import DAO.OrderTableImpl;
import DAO.TradeTableImpl;
import DAO.UserTableImpl;
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

	@Override
	public int PlaceOrder(Order order) {
		// TODO Auto-generated method stub
		
		int n = o.AddOrder(order);
		OrderMatching om = new OrderMatching();
		om.matchOrder(order);
		return n;
	}

	@Override
	public int GetStatistics(String cat) {
		// TODO Auto-generated method stub
		
		if(cat == "order")
		{
			OrderTableImpl o = new OrderTableImpl();
			return o.GetCount();
		}
		else if(cat == "trade")
		{
			TradeTableImpl t = new TradeTableImpl();
			return t.GetCount();
		}
		else if(cat == "user")
		{
			UserTableImpl u = new UserTableImpl();
			return u.GetCount();
		}
		else
		{
			System.out.println("statistics not available for the required category");
			return 0;
		}
	}

	@Override
	public int GetStatisticsUser(double user_id, String cat) {
		// TODO Auto-generated method stub
		
		if(cat == "order")
		{
			OrderTableImpl o = new OrderTableImpl();
			int n = o.GetCountUser(user_id);
			return n;
		}
		else if(cat == "trade")
		{
			TradeTableImpl t = new TradeTableImpl();
			int n = t.GetCountUser(user_id);
			return n;
		}
		else if(cat == "position")
		{
			UserTableImpl u = new UserTableImpl();
			int n = u.GetPosition(user_id);
			return n;
		}
		else
		{
			System.out.println("Please Enter valid argument for the function");
			return 0;
		}
			
	}
	

}
