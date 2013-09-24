package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private Integer userID;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String address;
	@Column
	private Integer creditCard;
	@Column
	private String DOB;
	@Column
	private boolean hasConfirmedAccount;
	@Column
	private boolean loggedIn;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(Integer creditCard) {
		this.creditCard = creditCard;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public boolean isHasConfirmedAccount() {
		return hasConfirmedAccount;
	}
	public void setHasConfirmedAccount(boolean hasConfirmedAccount) {
		this.hasConfirmedAccount = hasConfirmedAccount;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
