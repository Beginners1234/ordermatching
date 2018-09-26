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

public class OrderTableImpl implements OrderTable {

	@Override
	public int DropOrderTable() {
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
			String ordercat = set.getString("order_category");
			String ordertype = set.getString("order_type");
			Date order_time = set.getDate("order_time");
			double quant = set.getDouble("quantity");
			double price = set.getDouble("price");
			String orderst = set.getString("order_status");
			boolean aon = set.getBoolean("aon");
	
			Order order1 = new Order(ordercat, ordertype, order_time, quant, price, UserId, orderst, aon);
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
				String ordercat = set.getString("order_category");
				String ordertype = set.getString("order_type");
				Date order_time = set.getDate("order_time");
				double quant = set.getDouble("quantity");
				double price = set.getDouble("price");
				double userid = set.getDouble("user_id");
				boolean aon = set.getBoolean("aon");
				
				Order order = new Order(ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				orders.add(order);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public int AddOrder(Order order) {
		// TODO Auto-generated method stub
		
		int rowsAdded = 0;
		String ADDORDER = "insert into order_details values(?,?,?,?,?,?,?,?,?)";
		//String ADDORDER = "insert into ORDER_DETAILS values('buy','limit',getdate(),12,12,100, 'pending',1, 10)";

					
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDORDER);
			ps.setString(1, order.getOrderCategory());
			ps.setString(2, order.getOrderType());
			//ps.setDate(3, (java.sql.Date) order.getOrderTime());
			ps.setObject(3, new java.sql.Timestamp(order.getOrderTime().getTime()));
			ps.setDouble(4, order.getOrderQuantity());
			ps.setDouble(5, order.getOrderPrice());
			ps.setDouble(6, order.getUserId());
			ps.setString(7, order.getOrderStatus());
			ps.setBoolean(8, order.isAon());
			ps.setDouble(9, order.getOrderQuantity());
			
			rowsAdded = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rowsAdded = 0;
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
				String ordercat = set.getString("order_category");
				String ordertype = set.getString("order_type");
				Date order_time = set.getDate("order_time");
				double quant = set.getDouble("quantity");
				double price = set.getDouble("price");
				double userid = set.getDouble("user_id");
				boolean aon = set.getBoolean("aon");
				
				Order allorder = new Order(ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				ordersall.add(allorder);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersall;
	}


	@Override
	public List<Order> GetOrderForMatching(String order_categ, Double quantity) {
		// TODO Auto-generated method stub
		String GETORDERSFORMATCH;
		List<Order> ordersmatch = new ArrayList<>();
		if(order_categ == "BUY")
		{
			GETORDERSFORMATCH = "SELECT TOP ? * FROM order_details WHERE order_category = ? "
					+ "AND order_type = 'LIMIT' AND order_status = 'PENDING' ORDER BY price DESC";
		}
		else
		{
			GETORDERSFORMATCH = "SELECT TOP ? * FROM order_details WHERE order_category = ? "
					+ "AND order_type = 'LIMIT' AND order_status = 'PENDING' ORDER BY price";

		}
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETORDERSFORMATCH);
			ps.setDouble(1, quantity);
			ps.setString(2, order_categ);
			
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String orderst_m = set.getString("order_status");
				String ordercat_m = set.getString("order_category");
				String ordertype_m = set.getString("order_type");
				Date order_time_m = set.getDate("order_time");
				double quant_m = set.getDouble("quantity");
				double price_m = set.getDouble("price");
				double userid_m = set.getDouble("user_id");
				boolean aon_m = set.getBoolean("aon");
				
				Order ordermatch = new Order(ordercat_m, ordertype_m, order_time_m, quant_m, price_m, userid_m, orderst_m, aon_m);
				ordersmatch.add(ordermatch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersmatch;

	}

	@Override
	public int UpdateOrderByOrderId(Order order) {
		
		double oid = order.getOrderId();
		int isupdate = 0;
		
		String UpdateOrder = "UPDATE order_details SET order_status = ?, remianing_quantity = ? WHERE order_id = ?";
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(UpdateOrder);
			ps.setString(1, order.getOrderStatus());
			ps.setDouble(2, order.getRemaining_quantity());
			ps.setDouble(3, oid);
			
			isupdate = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isupdate;
		
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		String getcount = "SELECT COUNT(order_id) from order_details WHERE DATEPART(DD, order_time) = DATEPART(DD, GETDATE())"
				+ "AND DATEPART(MM, order_time) = DATEPART(MM, GETDATE()) "
				+ "AND DATEPART(YYYY, order_time) = DATEPART(YYYY, GETDATE())";
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
						
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int GetCountUser(double user_id) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		String getcount = "SELECT COUNT(order_id) from order_details WHERE user_id = ? AND DATEPART(DD, order_time) = DATEPART(DD, GETDATE())"
				+ "AND DATEPART(MM, order_time) = DATEPART(MM, GETDATE()) "
				+ "AND DATEPART(YYYY, order_time) = DATEPART(YYYY, GETDATE())";
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			ps.setDouble(1, user_id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;

		
	}

}
