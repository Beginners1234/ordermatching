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
import pojo.User;

public class UserTableImpl implements UserTable {

	@Override
	public int DropUserTable() {
		// TODO Auto-generated method stub
		int delete = 0;
		Connection con = MyConnection.openConnection();
		String DROPUSER = "drop table user_details";
		
		try {
			PreparedStatement ps = con.prepareStatement(DROPUSER);
			delete = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;

	}

	@Override
	public List<User> GetAllUsers() {
		// TODO Auto-generated method stub
		List<User> usersall = new ArrayList<>();
		
		String GETALLUSERS = "SELECT * FROM user_details";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLUSERS);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				double loginid = set.getDouble("login_id");
				double userid = set.getDouble("user_id");
				String name = set.getString("name");
				String password = set.getString("password");
				double contact = set.getDouble("contact");
				Date regist = set.getDate("reg");
				
				User alluser = new User(userid, loginid, password, contact, name, (java.sql.Date) regist);
				usersall.add(alluser);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersall;

	}

	@Override
	public List<User> GetUserByUsername(Double LoginId) {
		// TODO Auto-generated method stub
		List<User> usersid = new ArrayList<>();
		
		String GETUSERBYNAME = "SELECT * FROM user_details WHERE login_id = ?";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETUSERBYNAME);
			ps.setDouble(1, LoginId);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				double loginid = set.getDouble(1);
				double userid = set.getDouble("user_id");
				String name = set.getString("name");
				String password = set.getString("password");
				double contact = set.getDouble("contact");
				Date regist = set.getDate("reg");
				User user1 = new User(userid, loginid, password, contact, name, (java.sql.Date) regist);
				usersid.add(user1);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersid;

	}

	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String ADDUSER = "insert into user_details values(?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDUSER);
			
			ps.setDouble(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setDouble(3, user.getLoginId());
			ps.setString(4, user.getPassword());
			ps.setDouble(5, user.getContact());
			ps.setObject(6, new java.sql.Timestamp(user.getReg().getTime()));
			ps.setDate(6, user.getReg());
			rowsAdded = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		int count = 0;
		
		String getcount = "SELECT COUNT(user_id) from user_details WHERE DATEPART(DD, reg) = DATEPART(DD, GETDATE())"
				+ "AND DATEPART(MM, reg) = DATEPART(MM, GETDATE()) "
				+ "AND DATEPART(YYYY, reg) = DATEPART(YYYY, GETDATE())";
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
	public int GetPosition(double user_id) {
		// TODO Auto-generated method stub
		
		int bposition = 0;
		int sposition = 0;
		int position = 0;
		
		String buyposition = "SELECT SUM(quantity*price) FROM order_details WHERE user_id = ? AND "
				+ "order_status = 'COMPLETED' AND order_category = 'BUY'";

		String sellposition = "SELECT SUM(quantity*price) FROM order_details WHERE user_id = ? AND "
				+ "order_status = 'COMPLETED' AND order_category = 'SELL'";

		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(buyposition);
			ps.setDouble(1, user_id);
			PreparedStatement ps1 = con.prepareStatement(sellposition);
			ps1.setDouble(1, user_id);
			
			bposition = ps.executeUpdate();
			sposition = ps1.executeUpdate();
			position = bposition - sposition;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return position;
	}

}

