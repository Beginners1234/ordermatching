package DAO;

import java.util.List;

import pojo.Trade;

public interface TradeTable {
	public double DropTradeTable();
	public List<Trade> GetAllTrades();
	public double AddTrade(Trade trade);
	public double GetCount();

}
