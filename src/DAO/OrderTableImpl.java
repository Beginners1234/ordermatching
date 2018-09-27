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
		
		int delete = 0;
		Connection con = MyConnection.openConnection();
		String DROPORDER = "drop table order_details";
		
		try {
			PreparedStatement ps = con.prepareStatement(DROPORDER);
			delete = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	// TODO Auto-generated method stub
	public List<Order> GetOrderByUserId(Double UserId, int quantity) {		
		
	List<Order> ordersid = new ArrayList<>();
	String GETORDERBYID = "SELECT TOP (?) * FROM order_details WHERE user_id_order = ? ORDER BY order_time DESC";
	//String GETORDERBYID = "SELECT * FROM order_details WHERE user_id_order = ?";
	
	try(Connection con = MyConnection.openConnection();) {
		PreparedStatement ps = con.prepareStatement(GETORDERBYID);
		ps.setInt(1, quantity);
		ps.setDouble(2, UserId);
		ResultSet set = ps.executeQuery();
		while(set.next())
		{
			String ordercat = set.getString("order_category");
			String ordertype = set.getString("order_type");
			//ps.setObject(3, new java.sql.Timestamp(order.getOrderTime().getTime()));
			Date order_time = set.getDate("order_time");
			System.out.println(order_time);
			double quant = set.getDouble("quantity");
			double price = set.getDouble("price");
			String orderst = set.getString("order_status");
			boolean aon = set.getBoolean("aon");
			double orderid = set.getDouble("order_id");
			double remquan = set.getDouble("remaining_quantity");
			
			Order order1 = new Order(ordercat, ordertype, order_time, quant, price, UserId, orderst, aon);
			order1.setOrderId(orderid);
			order1.setRemaining_quantity(remquan);
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
		status=status.toUpperCase();
		List<Order> orders = new ArrayList<>();
		
		String GETALLORDERS = "SELECT * FROM ORDER_DETAILS WHERE order_status = ? ORDER BY order_time DESC";
		
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
				double userid = set.getDouble("user_id_order");
				boolean aon = set.getBoolean("aon");
				double orderid = set.getDouble("order_id");
				double remquan = set.getDouble("remaining_quantity");
				
				Order order = new Order(ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				order.setOrderId(orderid);
				order.setRemaining_quantity(remquan);
				orders.add(order);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order AddOrder(Order order) {
		//adds order to db and gets irder_id and adds ot object
		order.setOrderCategory(order.getOrderCategory().toUpperCase());
		order.setOrderType(order.getOrderType().toUpperCase());
		order.setOrderStatus(order.getOrderStatus().toUpperCase());
		
		String ADDORDER = "insert into order_details output inserted.* values(?,?,?,?,?,?,?,?,?);SELECT SCOPE_IDENTITY();";
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
			ps.setDouble(9, order.getRemaining_quantity());
			
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
			order.setOrderId(rs.getDouble(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	@Override
	public List<Order> GetAllOrders () {
		// TODO Auto-generated method stub
		
		List<Order> ordersall = new ArrayList<>();
 		
		String GETALLORDERS = "SELECT * FROM ORDER_DETAILS ORDER BY order_time DESC";
		
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
				double userid = set.getDouble("user_id_order");
				boolean aon = set.getBoolean("aon");
				double orderid = set.getDouble("order_id");
				double remquan = set.getDouble("remaining_quantity");
				
				Order allorder = new Order(ordercat, ordertype, order_time, quant, price, userid, orderst, aon);
				allorder.setOrderId(orderid);
				allorder.setRemaining_quantity(remquan);
				ordersall.add(allorder);
				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersall;
	}


	@Override
	public List<Order> GetOrderForMatching(String order_categ, int quantity) {
		// TODO Auto-generated method stub
		String GETORDERSFORMATCH;
		List<Order> ordersmatch = new ArrayList<>();
		if(order_categ == "BUY")
		{
			GETORDERSFORMATCH = "SELECT TOP (?) * FROM order_details WHERE order_category = ? "
					+ "AND order_type = 'LIMIT' AND order_status = 'PENDING' ORDER BY price DESC";
		}
		else
		{
			GETORDERSFORMATCH = "SELECT TOP (?) * FROM order_details WHERE order_category = ? "
					+ "AND order_type = 'LIMIT' AND order_status = 'PENDING' ORDER BY price";

		}
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETORDERSFORMATCH);
			ps.setInt(1, quantity);
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
				double userid_m = set.getDouble("user_id_order");
				boolean aon_m = set.getBoolean("aon");
				double orderid_m = set.getDouble("order_id");
				double remquan_m = set.getDouble("remaining_quantity");
				
				Order ordermatch = new Order(ordercat_m, ordertype_m, order_time_m, quant_m, price_m, userid_m, orderst_m, aon_m);
				ordermatch.setOrderId(orderid_m);
				ordermatch.setRemaining_quantity(remquan_m);
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
		
		String UpdateOrder = "UPDATE order_details SET order_status = ?, remaining_quantity = ? WHERE order_id = ?";
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
		
		String getcount = "SELECT COUNT(order_id) AS cnt from order_details WHERE DATEPART(DD, order_time) = DATEPART(DD, GETDATE())"
				+ "AND DATEPART(MM, order_time) = DATEPART(MM, GETDATE()) "
				+ "AND DATEPART(YYYY, order_time) = DATEPART(YYYY, GETDATE())";
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				count = set.getInt("cnt");
			}
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
		
		String getcount = "SELECT COUNT(order_id) AS cnt from order_details WHERE user_id_order = ? AND DATEPART(DD, order_time) = DATEPART(DD, GETDATE())"
				+ "AND DATEPART(MM, order_time) = DATEPART(MM, GETDATE()) "
				+ "AND DATEPART(YYYY, order_time) = DATEPART(YYYY, GETDATE())";
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			ps.setDouble(1, user_id);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				count = set.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	
	}
}
