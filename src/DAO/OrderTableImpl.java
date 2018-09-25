package DAO;

import java.util.List;

import pojo.Order;

public class OrderTableImpl implements OrderTable {

	@Override
	public void DropOrderTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public List GetOrderByUserId(String UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List GetAllOrders(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double AddOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Order getFirstSellOrder() {
		//gets sell order with min cost and waiting status from db
		return null;
	}
	
	public Order getFirstBuyOrder() {
		//gets buy order with max cost and waiting status from db
		return null;
	}
}
