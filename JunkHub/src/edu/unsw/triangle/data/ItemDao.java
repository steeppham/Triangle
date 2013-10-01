package edu.unsw.triangle.data;

import java.util.List;

import edu.unsw.triangle.model.Item;

public interface ItemDao
{
	public List<Item> getAll();
	
	public List<Item> findById(int id);
	
	public void update(Item value);
	
	public void detele(Item value);
}
