package pojo;

import java.util.Date;

public class Trade {
	private double tradeId;//primary key
	private double orderId_buy;//foreign key from order
	private double orderId_sell;//foreign key from order
	private double userId_buy;
	private double userId_sell;
	private double tradedPrice;
	private double tradedQuantity;
	private Date tradedTime;

	public Trade(double orderId_buy, double orderId_sell, double userId_buy, double userId_sell,
			double tradedPrice, double tradedQuantity, Date tradedTime) {
		super();
		this.orderId_buy = orderId_buy;
		this.orderId_sell = orderId_sell;
		this.userId_buy = userId_buy;
		this.userId_sell = userId_sell;
		this.tradedPrice = tradedPrice;
		this.tradedQuantity = tradedQuantity;
		this.tradedTime = tradedTime;
	}
	public double getTradeId() {
		return tradeId;
	}
	public void setTradeId(double tradeId) {
		this.tradeId = tradeId;
	}
	public double getOrderId_buy() {
		return orderId_buy;
	}
	public void setOrderId_buy(double orderId_buy) {
		this.orderId_buy = orderId_buy;
	}
	public double getOrderId_sell() {
		return orderId_sell;
	}
	public void setOrderId_sell(double orderId_sell) {
		this.orderId_sell = orderId_sell;
	}
	public double getUserId_buy() {
		return userId_buy;
	}
	public void setUserId_buy(double userId_buy) {
		this.userId_buy = userId_buy;
	}
	public double getUserId_sell() {
		return userId_sell;
	}
	public void setUserId_sell(double userId_sell) {
		this.userId_sell = userId_sell;
	}
	public double getTradedPrice() {
		return tradedPrice;
	}
	public void setTradedPrice(double tradedPrice) {
		this.tradedPrice = tradedPrice;
	}
	public double getTradedQuantity() {
		return tradedQuantity;
	}
	public void setTradedQuantity(double tradedQuantity) {
		this.tradedQuantity = tradedQuantity;
	}
	public Date getTradedTime() {
		return tradedTime;
	}
	public void setTradedTime(Date tradedTime) {
		this.tradedTime = tradedTime;
	}
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", orderId_buy=" + orderId_buy + ", orderId_sell=" + orderId_sell
				+ ", userId_buy=" + userId_buy + ", userId_sell=" + userId_sell + ", tradedPrice=" + tradedPrice
				+ ", tradedQuantity=" + tradedQuantity + ", tradedTime=" + tradedTime + "]";
	}
	public Trade() {
		super();
	}
	
	
	
}
