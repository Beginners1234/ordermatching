package DAO;

import java.util.List;

import pojo.User;

public interface UserTable {
	public void DropUserTable();
	public User GetUserByUsername(String LoginId);
	public List GetAllUsers();
	public double AddUser(User user);

}
