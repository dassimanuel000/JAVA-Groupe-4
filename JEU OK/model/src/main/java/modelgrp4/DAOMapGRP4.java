package modelgrp4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entitygrp4.LineGRP4;

/**
 * The Class DAOHelloWorld.
 *
 * @author GRoupe 4
 */
class DAOMapGRP4 extends DAOEntityGRP4<LineGRP4>{

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMapGRP4(final Connection connection) throws SQLException {
		super(connection);
	}


	public String find(int id, int map) {
		String line = " ";
		String name = "line" + map;	
		try {
			final String sql = "{call getLineMap1(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				line = resultSet.getString(name);
			}
			return line;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
