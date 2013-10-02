package edu.unsw.triangle.data;

import java.sql.SQLException;
import java.util.List;

import edu.unsw.triangle.model.Item;

public interface ItemDao
{
	public List<Item> getAll();
	
	public Item findById(int id);
	
	public void update(Item value);
	
	public void detele(Item value);
	
	public List<Item> findByTitle(String title) throws SQLException;
}
