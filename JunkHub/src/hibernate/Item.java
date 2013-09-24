package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
@Id
private String itemId;
@Column
private String title;
@Column
private String category;
@Column
private Integer picture; //picture as 0's and 1's perhaps?
@Column
private String desciption;//limit 100 words
@Column
private String postDetails;
@Column
private String reservePrice;
@Column
private String endTime; // optional
@Column
private String currentPrice;
@Column
private boolean halt; // 1 halt 0 continue
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Integer getPicture() {
	return picture;
}
public void setPicture(Integer picture) {
	this.picture = picture;
}
public String getDesciption() {
	return desciption;
}
public void setDesciption(String desciption) {
	this.desciption = desciption;
}
public String getPostDetails() {
	return postDetails;
}
public void setPostDetails(String postDetails) {
	this.postDetails = postDetails;
}
public String getReservePrice() {
	return reservePrice;
}
public void setReservePrice(String reservePrice) {
	this.reservePrice = reservePrice;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public String getCurrentPrice() {
	return currentPrice;
}
public void setCurrentPrice(String currentPrice) {
	this.currentPrice = currentPrice;
}
public boolean isHalt() {
	return halt;
}
public void setHalt(boolean halt) {
	this.halt = halt;
}
}
