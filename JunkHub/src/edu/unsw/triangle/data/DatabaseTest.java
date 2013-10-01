package edu.unsw.triangle.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseTest 
{
	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	public DatabaseTest() 
	{
		try 
		{
			// Get DataSource
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/junkdb");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void probe()
	{
		ResultSet resultSet = null;
        try 
        {
            // Get Connection and Statement
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) 
            {
                System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=statement)statement.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=connection)connection.close();} catch (SQLException e) 
            {e.printStackTrace();}
        }
	}

}
