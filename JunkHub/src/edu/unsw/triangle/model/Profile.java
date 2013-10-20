package edu.unsw.triangle.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A bean that represents a user profile information. 
 */
public class Profile implements Serializable
{
	public enum AccountStatus
	{
		NOT_ACTIVE,
		ACTIVE,
		PENDING;
	}
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String nickname;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private Date dob;
	private int credit;
	private boolean isAdmin;
	private AccountStatus status;
	
	public String getUsername() {
		return username;
	}
	public Profile setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Profile setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getNickname() {
		return nickname;
	}
	public Profile setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	public Profile setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public String getLastname() {
		return lastname;
	}
	public Profile setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Profile setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Profile setAddress(String address) {
		this.address = address;
		return this;
	}
	public Date getDobObject() {
		if (dob == null)
			return null;
		return (Date) dob.clone();
	}
	
	public String getDob()
	{
		if (getDobObject() == null)
			return "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(dob);
	}
	
	public Profile setDob(Date dob) {
		this.dob = (Date) dob.clone();
		return this;
	}
	public int getCredit() {
		return credit;
	}
	public Profile setCredit(int credit)
	{
		this.credit = credit;
		return this;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public Profile setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}
	public Profile setStatus(AccountStatus status) {
		this.status = status;
		return this;
	}
	public java.sql.Date getDobSQLObject() 
	{
		return new java.sql.Date(this.dob.getTime());
	}
	
	@Override
	public int hashCode() 
	{
		HashCodeBuilder builder = new HashCodeBuilder();
	    builder.append(getUsername());
	    builder.append(getEmail());
	    builder.append(getCredit());
	    return builder.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		 if (obj instanceof Profile) {
	        Profile other = (Profile) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(getUsername(), other.getUsername());
	        builder.append(getEmail(), other.getEmail());
	        builder.append(getCredit(), other.getCredit());
	        return builder.isEquals();
	    }
	    return false;
	}
	
	
}
