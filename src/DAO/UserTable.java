package DAO;

import java.util.List;

import pojo.User;

public interface UserTable {
	public double DropUserTable();
	public List<User> GetUserByUsername(Double LoginId);
	public List<User> GetAllUsers();
	public double AddUser(User user);

}
