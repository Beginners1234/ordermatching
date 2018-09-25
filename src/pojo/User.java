package pojo;

public class User {
	private double userId;// primary key
	private String loginId;
	private String password;
	private String contact;
	private String name;

	public User(double userId, String loginId, String password, String contact, String name, double balance) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.contact = contact;
		this.name = name;
		this.balance = balance;
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
				+ ", name=" + name + ", balance=" + balance + "]";
	}
	public double getUserId() {
		return userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private double balance;
}
