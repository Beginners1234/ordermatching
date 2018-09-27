package DAO;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import pojo.Trade;

public class TestTradeTableDAO {
	/*
	 * public int DropTradeTable();
	public List<Trade> GetAllTrades();
	public int AddTrade(Trade trade);
	public int GetCount();
	public int GetCountUser(double user_id);
	public List<Trade> GetTradesByUserId(Double UserId, int quantity);
	 */
	
	TradeTableImpl impl=new TradeTableImpl();
	
	@Test
	public void testGetAllTrades() {
		List<Trade> list=impl.GetAllTrades();
		list.forEach(System.out::println);
	}
	
	@Test
	public void testAddTrade() {
		Trade trade=new Trade(81, 91, 99, 88, 100, 100, new Date());
		int ret=impl.AddTrade(trade);
		//System.out.println(ret);
		assert(ret==1);
	}
	
	@Test
	public void testGetCount() {
		int ret=impl.GetCount();
		System.out.println(ret);
	}
	
	@Test
	public void testGetCountUser() {
		int ret=impl.GetCountUser(88d);
		System.out.println(ret);
	}
	
	@Test
	public void testGetTradesByUserId() {
		List<Trade> list=impl.GetTradesByUserId(88d, 10);
		System.out.println(list.size());
		list.forEach(System.out::println);
	}
	
	
	

}
