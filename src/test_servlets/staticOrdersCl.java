package test_servlets;

import java.util.ArrayList;
import java.util.List;

import pojo.Order;

public class staticOrdersCl {
	static public List<Order> orders;
	
	public staticOrdersCl() {
		// TODO Auto-generated constructor stub
		orders=new ArrayList<>();
	}
	
	static public void clearList()
	{
		if(!orders.isEmpty())
		{
			orders.clear();
		}
		
	}
	
	static public void addToList(Order o)
	{
		orders.add(o);
	}
	static public List<Order> getList()
	{
		return orders;
	}

}
