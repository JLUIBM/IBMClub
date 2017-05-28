package cn.jluibm.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.jluibm.model.dao.IDao;
import cn.jluibm.utils.JDBCTools;
import cn.jluibm.utils.ReflectionTools;

public abstract class BaseDao<T> implements IDao<T>
{

	protected Class<T> clazz;

	@Override
	public int update(String sql, Object... args)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int primaryKey = -1;
		
		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
				primaryKey = resultSet.getInt(1);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
		return primaryKey;
	}

	@Override
	public T getSingleObject(String sql, Object... args)
	{
		List<T> result = getForList(sql, args);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	@Override
	public List<T> getForList(String sql, Object... args)
	{
		List<T> entities = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			List<String> columnLabel = new ArrayList<>();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int j = 0; j < columnCount; j++)
			{
				String attr = rsmd.getColumnLabel(j + 1);
				columnLabel.add(attr);
			}

			T entity = null;
			while (resultSet.next())
			{
				try
				{
					entity = clazz.newInstance();
					for (int k = 0; k < columnCount; k++)
					{
						Object value = resultSet.getObject(k + 1);
						ReflectionTools.setter(entity, columnLabel.get(k), value);
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				entities.add(entity);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return entities;
	}

	@Override
	public Object getSingleValue(String sql, Object... args)
	{
		Object value = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				value = resultSet.getObject(1);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return value;
	}
}
