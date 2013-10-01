package edu.unsw.triangle.data;

import java.sql.Connection;
import java.util.List;

import edu.unsw.triangle.model.Item;

public class ItemDaoImpl extends GenericDao implements ItemDao
{
	public ItemDaoImpl(Connection connection) 
	{
		super(connection);
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Item value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Item value) {
		// TODO Auto-generated method stub
		
	}
}
