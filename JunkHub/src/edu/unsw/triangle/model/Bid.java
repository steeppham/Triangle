package edu.unsw.triangle.model;

import java.io.Serializable;

public class Bid implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	String bidder;
	float bid;
	int itemId;
	Item item;
	
	public String getBidder() {
		return bidder;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public String getBid() {
		return Float.toString(bid);
	}
	public float getBidFloat() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}
