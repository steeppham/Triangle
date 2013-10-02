package edu.unsw.triangle.data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.model.Bid;
import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;

public class ItemDaoImpl extends GenericDao implements ItemDao
{
	private final Logger logger = Logger.getLogger(ItemDaoImpl.class.getName());
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

	@Override
	public void add(Item item) throws SQLException 
	{
		String query = "INSERT INTO ITEMS(TITLE, CATEGORY, PICTURE, DESCRIPTION, POSTAGE, RESERVE, START, INC, OWNER, STATUS) " +
						"VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, item.getTitle());
		statement.setString(2, item.getCategory());
		statement.setString(3, item.getPicture());
		statement.setString(4, item.getDescription());
		statement.setString(5, item.getPostage());
		statement.setBigDecimal(6, BigDecimal.valueOf(item.getReserve()));
		statement.setBigDecimal(7, BigDecimal.valueOf(item.getStart()));
		statement.setBigDecimal(8, BigDecimal.valueOf(item.getIncrement()));
		statement.setString(9, item.getOwner());
		statement.setInt(10, item.getStatus().ordinal());
		
		int result = statement.executeUpdate();
		logger.info("Item " + item.getTitle() + "successfully inserted into repository"+ result);
		statement.close();
	}

	@Override
	public void updateItemBid(Bid bid) throws SQLException 
	{
		String query = "UPDATE ITEMS SET BID=?, BIDDER=? WHERE ID=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setBigDecimal(1, BigDecimal.valueOf(bid.getBidFloat()));
		statement.setString(2, bid.getBidder());
		statement.setInt(3, bid.getItemId());

		int result = statement.executeUpdate();
		logger.info("Item " + bid.getItemId() + "bid successfully updated"+ result);
		statement.close();
	}
}
