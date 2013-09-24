package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.derby.client.am.Decimal;
/**
 * note: the decimal datatypes will need to have a restriction to 2 decimal places
 * @author matthewwilliams
 *
 */
@Entity
public class Item {
@Id
private Integer itemId;
@Column
private String title;
@Column
private String category;
@Column
private String pictureLink; //picture as 0's and 1's perhaps?
@Column
private String desciption;//limit 100 words
@Column
private String postDetails;
@Column
private Decimal reservePrice;
@Column
private String endTime; // optional
@Column
private Decimal currentPrice; // in dollas
@Column
private boolean halt; // 1 halt 0 continue
public Integer getItemId() {
	return itemId;
}
public void setItemId(Integer itemId) {
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
public String getPictureLink() {
	return pictureLink;
}
public void setPictureLink(String picture) {
	this.pictureLink = picture;
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
public Decimal getReservePrice() {
	return reservePrice;
}
public void setReservePrice(Decimal reservePrice) {
	this.reservePrice = reservePrice;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public Decimal getCurrentPrice() {
	return currentPrice;
}
public void setCurrentPrice(Decimal currentPrice) {
	this.currentPrice = currentPrice;
}
public boolean isHalt() {
	return halt;
}
public void setHalt(boolean halt) {
	this.halt = halt;
}
}
