package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.MyConnection;
import pojo.Order;
import pojo.Trade;

public class TradeTableImpl implements TradeTable {

	@Override
	public int DropTradeTable() {
		// TODO Auto-generated method stub

		int delete_trade = 0;
		Connection con = MyConnection.openConnection();
		String DROPTRADE = "drop table TRADE_DETAILS";
		
		try {
			PreparedStatement ps = con.prepareStatement(DROPTRADE);
			delete_trade = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete_trade;
	}

	@Override
	public List<Trade> GetAllTrades() {
		
		List<Trade> tradesall = new ArrayList<>();
		
		String GETALLTRADES = "SELECT * FROM TRADE_DETAILS ORDER BY traded_time DESC";
		
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLTRADES);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				double tradeid = set.getDouble("trade_id");
//				Date trade_time = set.getDate("traded_time");
				Date trade_time = set.getTimestamp("traded_time");
				double quantity = set.getDouble("traded_quantity");
				double tradeprice = set.getDouble("traded_price");
				double useridbuy = set.getDouble("user_id_buy");
				double useridsell = set.getDouble("user_id_sell"); 
				double orderidbuy = set.getDouble("order_id_buy");
				double orderidsell = set.getDouble("order_id_sell");
				
				Trade trade = new Trade(orderidbuy, orderidsell, useridbuy, useridsell, tradeprice, quantity, trade_time);
				trade.setTradeId(tradeid);
				tradesall.add(trade);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tradesall;

	}


	@Override
	public int AddTrade(Trade trade) {

		int rowsAdded = 0;
		String ADDTRADE = "insert into trade_details values(?,?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDTRADE);
			
			ps.setDouble(1, trade.getOrderId_buy());
			ps.setDouble(2, trade.getOrderId_sell());
			ps.setDouble(3, trade.getUserId_buy());
			ps.setDouble(4, trade.getUserId_sell());
			ps.setDouble(5, trade.getTradedPrice());
			ps.setDouble(6, trade.getTradedQuantity());
			ps.setObject(7, new java.sql.Timestamp(trade.getTradedTime().getTime()));
			//ps.setDate(6, (java.sql.Date) trade.getTradedTime());
			
			rowsAdded = ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public int GetCount() {
		//gets todays trades count
		int count = 0;
		
		String getcount = "SELECT COUNT(trade_id) as cnt from trade_details WHERE DATEPART(DD, traded_time) = DATEPART(DD, GETDATE())"
						+ "AND DATEPART(MM, traded_time) = DATEPART(MM, GETDATE()) "
						+ "AND DATEPART(YYYY, traded_time) = DATEPART(YYYY, GETDATE())";	
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int GetCountUser(double user_id) {
		//gets number of trades by user today
		int count = 0;
		
		String getcount = "SELECT COUNT(trade_id) as cnt from trade_details WHERE user_id_buy = ? OR user_id_sell = ? AND DATEPART(DD, traded_time) = DATEPART(DD, GETDATE())"
						+ "AND DATEPART(MM, traded_time) = DATEPART(MM, GETDATE()) "
						+ "AND DATEPART(YYYY, traded_time) = DATEPART(YYYY, GETDATE())";		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			ps.setDouble(1, user_id);
			ps.setDouble(2, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Trade> GetTradesByUserId(Double UserId, int quantity) {
		//gets quantity number of trades by userid
		
		List<Trade> trades = new ArrayList<>();
		String quer="select * from trade_details where user_id_buy = ? OR user_id_sell = ? order by traded_time desc";
		
		/*
		String GETORDERID = "SELECT order_id FROM order_details WHERE user_id_order = ?";
		String GETTRADEBYOID = "SELECT * FROM trade_details WHERE order_id_buy = ? OR order_id_sell = ?";
		
		String uidbuy = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_buy";
		
		String uidsell = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_sell";
		 */
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(quer);
			ps.setDouble(1, UserId);
			ps.setDouble(2, UserId);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				double tradeid = set.getDouble("trade_id");
//				Date trade_time = set.getDate("traded_time");
				Date trade_time = set.getTimestamp("traded_time");
				double quantity2 = set.getDouble("traded_quantity");
				double tradeprice = set.getDouble("traded_price");
				double useridbuy = set.getDouble("user_id_buy");
				double useridsell = set.getDouble("user_id_sell"); 
				double orderidbuy = set.getDouble("order_id_buy");
				double orderidsell = set.getDouble("order_id_sell");
				
				Trade trade = new Trade(orderidbuy, orderidsell, useridbuy, useridsell, tradeprice, quantity2, trade_time);
				trade.setTradeId(tradeid);
				trades.add(trade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trades;

	}
}
