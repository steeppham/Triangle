package edu.unsw.triangle.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;

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
	public Item findById(int id) throws SQLException 
	{
		Item item = null;
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM ITEMS WHERE ID = " + id);
		
		if (result.next())
		{
			item = bindResultToItem(result);
		}
		
		statement.close();
		result.close();
		return item;
	}

	@Override
	public void update(Item value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Item value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> findByTitle(String title) throws SQLException 
	{
		List<Item> items = new ArrayList<Item>();
		// Find items by title that contains search string..
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM ITEMS WHERE TITLE LIKE '%" + title + "%'" );
		
		while (result.next())
		{
			items.add(bindResultToItem(result));
		}
		statement.close();
		result.close();
		return items;
	}
	
	private Item bindResultToItem(ResultSet result) throws SQLException
	{
		Item item = new Item();
		item.setId(result.getInt("ID"));
		item.setTitle(result.getString("TITLE"));
		item.setCategory(result.getString("CATEGORY"));
		item.setPicture(result.getString("PICTURE"));
		item.setDescription(result.getString("DESCRIPTION"));
		item.setPostage(result.getString("POSTAGE"));
		item.setReserve(result.getBigDecimal("RESERVE").floatValue());
		item.setStart(result.getBigDecimal("START").floatValue());
		item.setIncrement(result.getBigDecimal("INC").floatValue());
		item.setOwner(result.getString("OWNER"));
		item.setStatus(ItemStatus.values()[result.getInt("STATUS")]);
		item.setBidder(result.getString("BIDDER"));
		if (result.getBigDecimal("BID") != null)
			item.setBid(result.getBigDecimal("BID").floatValue());
		return item;
	}
}
