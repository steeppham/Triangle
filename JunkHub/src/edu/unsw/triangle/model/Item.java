package edu.unsw.triangle.model;

import java.io.Serializable;

public class Item implements Serializable
{
	public enum ItemStatus
	{
		NOT_ACTIVE,
		ACTIVE,
		SOLD,
		UNSOLD;
	}
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String category;
	private String picture;
	private String description;
	private String postage;
	private float reserve;
	private float start;
	private float increment;
	private String owner;
	private ItemStatus status;
	private String bidder;
	private float bid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getStart() {
		return start;
	}
	public float getIncrement() {
		return increment;
	}
	public String getOwner() {
		return owner;
	}
	public Item setOwner(String username)
	{
		this.owner = username;
		return this;
	}
	
	public ItemStatus getStatus() {
		return status;
	}
	public String getBidder() {
		return bidder;
	}
	public float getBid() {
		return bid;
	}
	public void setStart(float start) {
		this.start = start;
	}
	public void setIncrement(float increment) {
		this.increment = increment;
	}
	public Item setStatus(ItemStatus status) {
		this.status = status;
		return this;
	}
	public Item setBidder(String bidder) {
		this.bidder = bidder;
		return this;
	}
	public Item setBid(float bid) {
		this.bid = bid;
		return this;
	}

	public String getTitle() {
		return title;
	}
	public Item setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public Item setCategory(String category) {
		this.category = category;
		return this;
	}
	public String getPicture() {
		return picture;
	}
	public Item setPicture(String picture) {
		this.picture = picture;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Item setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getPostage() {
		return postage;
	}
	public Item setPostage(String postage) {
		this.postage = postage;
		return this;
	}
	public float getReserve() {
		return reserve;
	}
	public Item setReserve(float reserve) {
		this.reserve = reserve;
		return this;
	}
}
