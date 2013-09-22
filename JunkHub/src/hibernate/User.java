package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String userID;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String address;
	@Column
	private String creditCard;
	@Column
	private String DOB;
	@Column
	private boolean hasConfirmedAccount;
	@Column
	private boolean loggedIn;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
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
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
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
}
