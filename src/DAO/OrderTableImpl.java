package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;

import pojo.Order;

public class OrderTableImpl implements OrderTable {

	@Override
	public double DropOrderTable() {
		// TODO Auto-generated method stub
		
		int delete = 0;
		Connection con = MyConnection.openConnection();
		String DROPORDER = "drop table ORDER_DETAILS";
		
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
	public List GetOrderByUserId(Double UserId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List GetAllOrders(String status) {
		// TODO Auto-generated method stub
		
		List orders = new ArrayList<>();
		
		String GETALLORDERS = "SELECT * FROM ORDER_DETAILS WHERE order_status = ?";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLORDERS);
			ps.setString(1, status);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double AddOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List GetAllOrders () {
		// TODO Auto-generated method stub
		
		return null;
	}


}
