package pojo;

public class User {
	private double userId;// primary key
	private String loginId;
	private String password;
	private String contact;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", contact=" + contact
				+ ", name=" + name + "]";
	}
	public User(double userId, String loginId, String password, String contact, String name) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.contact = contact;
		this.name = name;
	}

}
