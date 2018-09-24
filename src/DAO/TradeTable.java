package DAO;

import java.util.List;

import pojo.Trade;

public interface TradeTable {
	public void DropTradeTable();
	public List GetAllTrades();
	public double AddTrade(Trade trade);

}
