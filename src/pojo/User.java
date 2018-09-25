package pojo;

public class User {
	private double userId;// primary key
	private double loginId;
	private String password;
	private double contact;
	private String name;
	
	public User(double userId, double loginId, String password, double contact, String name) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.contact = contact;
		this.name = name;
	}
	
	public double getUserId() {
		return userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	public double getLoginId() {
		return loginId;
	}
	public void setLoginId(double loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getContact() {
		return contact;
	}
	public void setContact(double contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", contact=" + contact
				+ ", name=" + name + "]";
	}

}
