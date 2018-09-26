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
		// TODO Auto-generated method stub
		
		List<Trade> tradesall = new ArrayList<>();
		
		String GETALLTRADES = "SELECT * FROM TRADE_DETAILS ORDER BY traded_time DESC";
		String uidbuy = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_buy";
		
		String uidsell = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_sell";
		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETALLTRADES);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				double tradeid = set.getDouble("trade_id");
				Date trade_time = set.getDate("traded_time");
				double quantity = set.getDouble("traded_quantity");
				double tradeprice = set.getDouble("traded_price");
				double orderidbuy = set.getDouble("order_id_buy");
				double orderidsell = set.getDouble("order_id_sell");
				
				Trade alltrades = new Trade(orderidbuy, orderidsell, Double.parseDouble(uidbuy), Double.parseDouble(uidsell), tradeprice, quantity, trade_time);
				tradesall.add(alltrades);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tradesall;

	}


	@Override
	public int AddTrade(Trade trade) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String ADDTRADE = "insert into trade_details values(?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDTRADE);
			
			ps.setDouble(1, trade.getTradeId());
			ps.setDouble(2, trade.getOrderId_buy());
			ps.setDouble(3, trade.getOrderId_sell());
			ps.setDouble(4, trade.getTradedPrice());
			ps.setDouble(5, trade.getTradedQuantity());
			ps.setObject(6, new java.sql.Timestamp(trade.getTradedTime().getTime()));
//			ps.setDate(6, (java.sql.Date) trade.getTradedTime());
			
			rowsAdded = ps.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		int count = 0;
		
		String getcount = "SELECT COUNT(trade_id) from trade_details WHERE DATEPART(DD, traded_time) = DATEPART(DD, GETDATE())"
						+ "AND DATEPART(MM, traded_time) = DATEPART(MM, GETDATE()) "
						+ "AND DATEPART(YYYY, traded_time) = DATEPART(YYYY, GETDATE())";		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int GetCountUser(double user_id) {
		// TODO Auto-generated method stub

		int count = 0;
		
		String getcount = "SELECT COUNT(trade_id) from trade_details WHERE user_id = ? AND DATEPART(DD, traded_time) = DATEPART(DD, GETDATE())"
						+ "AND DATEPART(MM, traded_time) = DATEPART(MM, GETDATE()) "
						+ "AND DATEPART(YYYY, traded_time) = DATEPART(YYYY, GETDATE())";		
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(getcount);
			ps.setDouble(1, user_id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Trade> GetTradesByUserId(Double UserId, int quantity) {
		// TODO Auto-generated method stub
		List<Trade> tradesid = new ArrayList<>();
		
		String GETORDERID = "SELECT order_id FROM order_details WHERE user_id_order = ?";
		String GETTRADEBYOID = "SELECT * FROM trade_details WHERE order_id_buy = ? OR order_id_sell = ?";
		
		String uidbuy = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_buy";
		
		String uidsell = "SELECT order_details.user_id_order FROM order_details INNER JOIN trade_details"
				+ " ON order_details.order_id = trade_details.order_id_sell";

		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(GETORDERID);
			ps.setDouble(1, UserId);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				PreparedStatement ps1 = con.prepareStatement(GETTRADEBYOID);
				ps1.setDouble(1, set.getDouble("order_id"));
				ps1.setDouble(2, set.getDouble("order_id"));
				ResultSet set1 = ps1.executeQuery();
				while(set1.next())
				{
					double orderidbuy = set.getDouble("order_id_buy");
					double orderidsell = set.getDouble("order_id_sell");
					double tradedprice = set.getDouble("traded_price");
					double quant = set.getDouble("traded_quantity");
					Date tradedtime = set.getDate("traded_time");
					
					Trade trade1 = new Trade(orderidbuy, orderidsell, Double.parseDouble(uidbuy), Double.parseDouble(uidsell), tradedprice, quant, tradedtime);
					tradesid.add(trade1);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tradesid;

	}
}
