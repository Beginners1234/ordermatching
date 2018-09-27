package DAO;

import java.util.List;

import pojo.User;

public interface UserTable {
	public int DropUserTable();
	public List<User> GetUserByLoginid(String LoginId);
	public List<User> GetAllUsers();
	public int AddUser(User user);
	public int GetCount();
	public int GetPosition(double user_id);
}

