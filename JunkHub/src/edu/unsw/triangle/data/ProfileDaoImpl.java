package edu.unsw.triangle.data;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.model.Profile.AccountStatus;

public class ProfileDaoImpl extends GenericDao implements ProfileDao
{
	private String TABLE = "PROFILES";
	private final Logger logger = Logger.getLogger(ProfileDaoImpl.class.getName());
	
	public ProfileDaoImpl(Connection connection) 
	{
		super(connection);
	}

	@Override
	public List<Profile> getAll() throws SQLException 
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE);
		
		while (result.next())
		{
			
		}
		
		return null;
	}

	@Override
	public List<Profile> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	// Updates profile details
	@Override
	public void update(Profile profile) throws SQLException 
	{
		//String query = "UPDATE PROFILES SET USERNAME=?, PASSWORD=?, NICKNAME=?, FIRSTNAME=?, LASTNAME=?, EMAIL=?, ADDRESS=?, DOB=?, CREDIT=?, STATUS=?, ADMIN=?";
		String query = "UPDATE PROFILES SET PASSWORD=?, NICKNAME=?, FIRSTNAME=?, LASTNAME=?, EMAIL=?, ADDRESS=?, DOB=?, CREDIT=? WHERE USERNAME=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, profile.getPassword());
		statement.setString(2, profile.getNickname());
		statement.setString(3, profile.getFirstname());
		statement.setString(4, profile.getLastname());
		statement.setString(5, profile.getEmail());
		statement.setString(6, profile.getAddress());
		statement.setDate(7, profile.getDobSQLObject());
		statement.setInt(8, profile.getCredit());
		statement.setString(9, profile.getUsername());
		//statement.setInt(9, profile.getStatus().ordinal());
		//statement.setInt(10, profile.isAdmin()? 1 : 0);

		int result = statement.executeUpdate();
		if (result == 1)
			logger.info("Profile " + profile.getUsername() + "is successfully updated"+ result);
		else
			throw new SQLException("Profile " + profile.getUsername() + "was not updated into the repository");
		statement.close();
	}

	@Override
	public void detele(Profile value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAllUsernames() throws SQLException 
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT USERNAME FROM " + TABLE);
		List<String> usernames = new ArrayList<String>();
		while (result.next())
		{
			
		}
		return null;
	}

	@Override
	public Profile findByUsername(String username) throws SQLException 
	{
		Profile profile = null;
		
		// Check that there is a username in the repository
		String countQuery= "SELECT COUNT(*) FROM " + TABLE + " WHERE USERNAME = ?";
		PreparedStatement countStatement = connection.prepareStatement(countQuery);
		countStatement.setString(1, username);
		ResultSet countResult = countStatement.executeQuery();
		countResult.next();
		int numberRows = countResult.getInt(1);
		//logger.info("The result set size is "+ numberRows);
		countStatement.close();
		countResult.close();
		if(numberRows != 0) 
		{
			// Fetch profile from repository
			String usernameQuery = "SELECT * FROM " + TABLE + " WHERE USERNAME = ?";;
			PreparedStatement statement = connection. prepareStatement(usernameQuery);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			result.next();
			String password = result.getString("PASSWORD");
			String nickname = result.getString("NICKNAME");
			String firstname = result.getString("FIRSTNAME");
			String lastname = result.getString("LASTNAME");
			String email = result.getString("EMAIL");
			String address = result.getString("ADDRESS");
			Date dob = result.getDate("DOB");
			int credit = result.getInt("CREDIT");
			int status = result.getInt("STATUS");
			boolean isAdmin = result.getBoolean("ADMIN");
			profile = new Profile().setUsername(username).setPassword(password).setFirstname(firstname).setLastname(lastname).
					setNickname(nickname).setEmail(email).setAddress(address).setDob(dob).setCredit(credit).setAdmin(isAdmin).
					setStatus(AccountStatus.values()[status]);
			statement.close();
			result.close();
		}
		
		return profile;
	}

	@Override
	public void insert(Profile profile) throws SQLException
	{
		logger.info("inserting profile: " + profile.getUsername() + " into repository");
		
		String query = "INSERT INTO PROFILES(USERNAME, PASSWORD, NICKNAME, FIRSTNAME, LASTNAME, EMAIL, ADDRESS, DOB, CREDIT, STATUS, ADMIN) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, profile.getUsername());
		statement.setString(2, profile.getPassword());
		statement.setString(3, profile.getNickname());
		statement.setString(4, profile.getFirstname());
		statement.setString(5, profile.getLastname());
		statement.setString(6, profile.getEmail());
		statement.setString(7, profile.getAddress());
		statement.setDate(8, profile.getDobSQLObject());
		statement.setInt(9, profile.getCredit());
		statement.setInt(10, profile.getStatus().ordinal());
		statement.setInt(11, profile.isAdmin()? 1 : 0);

		int result = statement.executeUpdate();
		if (result == 1)
			logger.info("Profile " + profile.getUsername() + "successfully inserted into repository"+ result);
		else
			throw new SQLException("Profile " + profile.getUsername() + "was not inserted into the repository");
		statement.close();
	}

}
