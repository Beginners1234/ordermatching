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
	public double DropUserTable() {
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
				
				User alluser = new User(userid, loginid, password, contact, name);
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
				
				User user1 = new User(userid, loginid, password, contact, name);
				usersid.add(user1);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersid;

	}

	@Override
	public double AddUser(User user) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String ADDUSER = "insert into user_details values(?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDUSER);
			
			ps.setDouble(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setDouble(3, user.getLoginId());
			ps.setString(4, user.getPassword());
			ps.setDouble(5, user.getContact());
			
			rowsAdded = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

}

