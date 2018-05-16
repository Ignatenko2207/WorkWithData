package it.dan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.dan.model.Order;

public class OrderDAO extends AbstractDAO<Order>
{
	@Override
	public void save(Order order)
	{
		String sql = "INSERT INTO order(client_id, item_id, amount) VALUES(?,?,?)";

		try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
		{
			statement.setString(1, order.getClientId());
			statement.setString(2, order.getItemId());
			statement.setInt(3, order.getAmount());

			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}

	@Override public void update(Order order)
	{
		String sql = "UPDATE public.order SET client_id=?, item_id=?, amount=? WHERE order_id=?";

		try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
		{
			statement.setString(1, order.getClientId());
			statement.setString(2, order.getItemId());
			statement.setInt(3, order.getAmount());
			statement.setInt(4, order.getOrderId());

			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}

	@Override public Order get(Object orderId)
	{
		Order order = new Order();

		String sql = "SELECT * FROM order WHERE order_id='" + orderId + "'";

		try (
			Connection        connection  = ConnectionToDB.getConnection();
			PreparedStatement statement  = connection.prepareStatement(sql);
			ResultSet rSet = statement.executeQuery();
			)
		{
			while ( rSet.next() )
			{
				order.setOrderId(rSet.getInt("order_id"));
				order.setClientId(rSet.getString("client_id"));
				order.setItemId(rSet.getString("item_id"));
				order.setAmount(rSet.getInt("amount"));

				return order;
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override public void delete(Object orderId)
	{
		String sql = "DELETE * FROM order WHERE order_id=?";

		try (
			Connection connection = ConnectionToDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			)
		{
			statement.setInt(1, (Integer) orderId);
			statement.executeUpdate();
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
	}
}
