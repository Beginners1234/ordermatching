package pojo;


import java.util.Date;

public class Order {
	private double orderId;//primary key
	private String orderCategory;//buy or sell
	private String orderType;//limit or market
	private Date orderTime;
	private double orderQuantity;
	private double orderPrice;//only if limit order
	private double userId;//foreign key from User
	private String orderStatus;// rejected,waiting or successful
	private boolean aon;//all or none
	private double remaining_quantity;
	
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
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
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
	public boolean isAon() {
		return aon;
	}
	public void setAon(boolean aon) {
		this.aon = aon;
	}


	
	public Order(double orderId, String orderCategory, String orderType, Date orderTime, double orderQuantity,
			double orderPrice, double userId, String orderStatus, boolean aon, double remaining_quantity) {
		this.orderId = orderId;
		this.orderCategory = orderCategory;
		this.orderType = orderType;
		this.orderTime = orderTime;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.aon = aon;
		this.remaining_quantity = remaining_quantity;
	}
	public double getRemaining_quantity() {
		return remaining_quantity;
	}
	public void setRemaining_quantity(double remaining_quantity) {
		this.remaining_quantity = remaining_quantity;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCategory=" + orderCategory + ", orderType=" + orderType
				+ ", orderTime=" + orderTime + ", orderQuantity=" + orderQuantity + ", orderPrice=" + orderPrice
				+ ", userId=" + userId + ", orderStatus=" + orderStatus + ", aon=" + aon + ", remaining_quantity="
				+ remaining_quantity + "]";
		
	}

}
