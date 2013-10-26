package edu.unsw.triangle.model;

import java.io.Serializable;

public class ItemPendingResult implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int itemId;
	private String owner;
	private String bidder;
	private boolean isAccept = false;
	
	public int getItemId() {
		return itemId;
	}
	public String getOwner() {
		return owner;
	}
	public String getBidder() {
		return bidder;
	}
	public boolean isAccept() {
		return isAccept;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}
	

}
