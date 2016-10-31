package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
	private Connection conn;

	@Before
	public void before() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "ramonik1987");
		if (conn == null) {
			return;
		}
		deleteForInsert();
	}

	public void deleteForInsert() {
		PreparedStatement ps = null;

		String sql = "delete from accomodation_fair_relation  where id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection connect(String type, String host, int port, String dbName, String user, String pw) {
		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		try {

			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pw).toString();

			System.out.println("URL:" + url);
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database:" + e.getMessage());

		}
		return conn;
	}

	@Test
	public void testSelect() throws SQLException {
		PreparedStatement ps = null;

		ResultSet rs = null;

		String sqlQuery = "select * from accomodation " + "JOIN accomodation_fair_relation "
				+ "ON accomodation_fair_relation.id_accomodation = accomodation.id " + "JOIN room_fair "
				+ "ON room_fair.id = accomodation_fair_relation.id_room_fair";
		try {
			ps = conn.prepareStatement(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rs = ps.executeQuery();
		boolean hasResult = rs.next();

		if (hasResult) {

			do {
				System.out.println("Room:" + rs.getString("type") + " Price: " + rs.getString("value") + " Season:"
						+ rs.getString("season"));

			} while (rs.next());
		} else {
			System.out.println("No result");
		}

	}

	@Test
	public void testInsert() {
		PreparedStatement ps = null;

		String sql = "insert into accomodation_fair_relation (id,id_accomodation, id_room_fair) values (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setInt(2, 1);
			ps.setInt(3, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "select * from accomodation_fair_relation where id= 3";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Assert.assertTrue("insert unsuccessfull", rs.next());
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@After
	public void after() throws SQLException {
		conn.close();
	}
}
