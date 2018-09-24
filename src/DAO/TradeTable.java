package DAO;

import java.util.List;

public interface TradeTable {
	public void DropTradeTable();
	public List GetAllTrades();
	public double AddTrade(Trade trade);

}
