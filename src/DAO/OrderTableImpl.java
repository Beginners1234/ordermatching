package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.MyConnection;

import pojo.Order;
import pojo.Trade;

public class OrderTableImpl implements OrderTable {

	@Override
	public double DropOrderTable() {
		// TODO Auto-generated method stub
		
		int delete = 0;
		Connection con = MyConnection.openConnection();
		String DROPORDER = "drop table order_details";
		
		try {
			PreparedStatement ps = con.prepareStatement(DROPORDER);
			delete = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public List<Order> GetOrderByUserId(Double UserId) {
		// TODO Auto-generated method stub
		
	List<Order> ordersid = new ArrayList<>();
		
	String GETORDERBYID = "SELECT * FROM order_details WHERE user_id = ?";
	
	try(Connection con = MyConnection.openConnection();) {
		PreparedStatement ps = con.prepareStatement(GETORDERBYID);
		ps.setDouble(1, UserId);
		ResultSet set = ps.executeQuery();
		while(set.next())
		{
			double userid = set.getDouble(1);
			double orderid = set.getDouble("order_id");
			String ordercat = set.getString("order_category");
			String ordertype = set.getString("order_type");
			Date order_time = set.getDate("order_time");
			double quant = set.getDouble("quantity");
			double price = set.getDouble("price");
			String orderst = set.getString("order_status");
			boolean aon = set.getBoolean("aon");
			
			Order order1 = new Order(orderid, ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
			ordersid.add(order1);
			
		}

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ordersid;
	}

	@Override
	public List<Order> GetAllOrders(String status) {
		// TODO Auto-generated method stub
		
		List<Order> orders = new ArrayList<>();
		
		String GETALLORDERS = "SELECT * FROM ORDER_DETAILS WHERE order_status = ?";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLORDERS);
			ps.setString(1, status);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String orderst = set.getString(1);
				double orderid = set.getDouble("order_id");
				String ordercat = set.getString("order_category");
				String ordertype = set.getString("order_type");
				Date order_time = set.getDate("order_time");
				double quant = set.getDouble("quantity");
				double price = set.getDouble("price");
				double userid = set.getDouble("user_id");
				boolean aon = set.getBoolean("aon");
				
				Order order = new Order(orderid, ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				orders.add(order);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public double AddOrder(Order order) {
		// TODO Auto-generated method stub
		
		int rowsAdded = 0;
		String ADDORDER = "insert into order_details values(?,?,?,?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDORDER);
			
			ps.setDouble(1, order.getOrderId());
			ps.setString(2, order.getOrderCategory());
			ps.setString(3, order.getOrderType());
			ps.setDate(4, (java.sql.Date) order.getOrderTime());
			ps.setDouble(5, order.getOrderQuantity());
			ps.setDouble(6, order.getOrderPrice());
			ps.setDouble(7, order.getUserId());
			ps.setString(8, order.getOrderStatus());
			ps.setBoolean(9, order.isAon());
			
			rowsAdded = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;

	}
	
	@Override
	public List<Order> GetAllOrders () {
		// TODO Auto-generated method stub
		
		List<Order> ordersall = new ArrayList<>();
		
		String GETALLORDERS = "SELECT * FROM ORDER_DETAILS";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLORDERS);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String orderst = set.getString("order_status");
				double orderid = set.getDouble("order_id");
				String ordercat = set.getString("order_category");
				String ordertype = set.getString("order_type");
				Date order_time = set.getDate("order_time");
				double quant = set.getDouble("quantity");
				double price = set.getDouble("price");
				double userid = set.getDouble("user_id");
				boolean aon = set.getBoolean("aon");
				
				Order allorder = new Order(orderid, ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				ordersall.add(allorder);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersall;
	}

	@Override
	public List<Order> GetOrderForMatching(String order_type, Double quantity) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}
