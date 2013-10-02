package edu.unsw.triangle.data;

import java.sql.SQLException;
import java.util.List;

import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.model.Item;

public interface ItemDao
{
	public List<Item> getAll();
	
	public Item findById(int id) throws SQLException;
	
	public void update(Item value);
	
	public void updateItemBid(Bid bid) throws SQLException;
	
	public void add(Item value) throws SQLException;
	
	public void detele(Item value);
	
	public List<Item> findByTitle(String title) throws SQLException;
}
