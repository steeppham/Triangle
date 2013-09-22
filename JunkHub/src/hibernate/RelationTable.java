package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RelationTable {
	@Id
	private String userID;
	@Id
	private String ItemID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
}
