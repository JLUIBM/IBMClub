package cn.jluibm.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools
{

	private static DataSource dataSource = new ComboPooledDataSource("ibmc3p0");

	public static Connection getConnection() throws SQLException
	{
		return dataSource.getConnection();
	}

	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection)
	{

		if (resultSet != null)
			try
			{
				resultSet.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		if (statement != null)
			try
			{
				statement.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		if (connection != null)
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

	}

}
