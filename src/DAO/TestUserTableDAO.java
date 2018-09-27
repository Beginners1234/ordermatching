package DAO;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.User;

public class TestUserTableDAO {
	
	UserTableImpl u = new UserTableImpl();
		
	@Test
	public void testGetUserByLoginid() 
	{
		List<User> list = u.GetUserByLoginid("chiragtnak");
		list.forEach(System.out::println);
	}
	
	@Test
	public void testGetAllUsers() 
	{
		List<User> list=u.GetAllUsers();
		for(User a:list) {
			System.out.println(a);
		}
		
	}
	
	@Test
	public void testAddUser()
	{
		System.out.println("Test add user");
		User user1 = new User("hello", "qwer", 122423, "sjfskjf", new Date());
		int ret=u.AddUser(user1);
		System.out.println("Return: "+ret);
	}
	
	@Test
	public void testGetCount() 
	{
		int cou = u.GetCount();
		System.out.println(cou);
	}
	
	@Test
	public void testGetPosition()
	{
		int pos = u.GetPosition(1001.0);
		System.out.println(pos);
	}
	

}