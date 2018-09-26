package connection;

import java.sql.Connection;

import org.junit.Test;

public class TestConnection {

	@Test
	public void testConnection() {
		System.out.println("Testing Connection");
		Connection con = MyConnection.openConnection();

		System.out.println(con);
		Connection c2on = MyConnection.openConnection();

		System.out.println(c2on);
	}
}
