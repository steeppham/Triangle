package edu.unsw.triangle.model;

import java.io.Serializable;

public class Item implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String category;
	private String picture;
	private String description;
	private String postage;
	private float reserve;
	private float startPrice;
	private float bidIncrement;
	private boolean isEnded;
	
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
	public float getStartPrice() {
		return startPrice;
	}
	public Item setStartPrice(float startPrice) {
		this.startPrice = startPrice;
		return this;
	}
	public float getBidIncrement() {
		return bidIncrement;
	}
	public Item setBidIncrement(float bidIncrement) {
		this.bidIncrement = bidIncrement;
		return this;
	}
	public boolean isEnded() {
		return isEnded;
	}
	public Item setIsEnded(boolean isEnded) {
		this.isEnded = isEnded;
		return this;
	}
}
