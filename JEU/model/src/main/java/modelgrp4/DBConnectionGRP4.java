package modelgrp4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnectionGRP4.
 *
 * @author Groupe 4
 */
final class DBConnectionGRP4 {
	/** The instance. */
	private static DBConnectionGRP4 INSTANCE = null;

	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnectionGRP4() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnectionGRP4 getInstance() {
		if (DBConnectionGRP4.INSTANCE == null) {
			DBConnectionGRP4.INSTANCE = new DBConnectionGRP4();
		}
		return DBConnectionGRP4.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBPropertiesGRP4 dbProperties = new DBPropertiesGRP4();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
