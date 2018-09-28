package DAO;

import java.util.List;

import pojo.User;

public interface UserTable {
	public int DropUserTable();
	public List<User> GetUserByLoginid(String LoginId);
	public List<User> GetAllUsers();
	public int AddUser(User user);
	public int GetCount();
	public double GetContactByOrderId(double user_id);
	public String GetPosition(double user_id);
	public String GetEmailByOrderId(double user_id);
}

