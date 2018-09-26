package DAO;

import java.util.List;
import pojo.Trade;

public interface TradeTable {
	public int DropTradeTable();
	public List<Trade> GetAllTrades();
	public int AddTrade(Trade trade);
	public int GetCount();
	public int GetCountUser(double user_id);
	public List<Trade> GetTradesByUserId(Double UserId, int quantity);
}
