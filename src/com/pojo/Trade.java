package com.pojo;

import java.sql.Date;

public class Trade {
	private double tradeId;//primary key
	private double orderId_buy;//foreign key from order
	private double orderId_sell;//foreign key from order
	private double userId_buy;
	private double userId_sell;
	private double tradedPrice;
	private double tradedQuantity;
	private String tradedTime;
    	
}
