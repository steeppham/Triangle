package edu.unsw.triangle.model;

import java.io.Serializable;

public class WebSession implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String username;
	private int userid;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
