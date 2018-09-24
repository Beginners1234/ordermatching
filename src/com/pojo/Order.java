package com.pojo;



public class Order {
	private double orderId;//primary key
	private String orderCategory;//buy or sell
	private String orderType;//limit or market
	private String orderTime;
	private double orderQuantity;
	private double orderPrice;//only if limit order
	private double userId;//foreign key from User
	private String orderStatus;// rejected,waiting or successful
	public double getOrderId() {
		return orderId;
	}
	public void setOrderId(double orderId) {
		this.orderId = orderId;
	}
	public String getOrderCategory() {
		return orderCategory;
	}
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public double getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public double getUserId() {
		return userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(double orderId, String orderCategory, String orderType, String orderTime, double orderQuantity,
			double orderPrice, double userId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderCategory = orderCategory;
		this.orderType = orderType;
		this.orderTime = orderTime;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.userId = userId;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return orderCategory +" "+ orderType +" "+ orderQuantity
				+" " + orderPrice + " "+ userId +" " + orderStatus ;
	}

}
