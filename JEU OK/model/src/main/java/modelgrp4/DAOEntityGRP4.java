package modelgrp4;

import java.sql.Connection;
import java.sql.SQLException;

import entitygrp4.EntityGRP4;

/**
 * The Class DAOEntityGRP4.
 *
 * @author Groupe 4
 *
 * @param <E>
 *          the element type
 */
abstract class DAOEntityGRP4<E extends EntityGRP4> {

	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOEntityGRP4(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}
}
