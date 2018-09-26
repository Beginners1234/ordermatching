package pojo;

import java.sql.Date;

public class User {
	private double userId;// primary key
	private String loginId;
	private String password;
	private double contact;
	private String name;
	private Date reg;
	
	public User(String loginId, String password, double contact, String name, Date reg) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.contact = contact;
		this.name = name;
		this.reg = reg;
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

	public Date getReg() {
		return reg;
	}

	public void setReg(Date reg) {
		this.reg = reg;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", contact=" + contact
				+ ", name=" + name + ", reg=" + reg + "]";
	}

}
