package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	private static Connection con;
	
	static {
	    generateConnection();		
	 }
	
	static private void generateConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Loaded successfully");
			
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=OMS", "sa", "sa123");
			System.out.println("connection successful");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//returns connection
	static public Connection openConnection()
	{
				try {
					if(con.isValid(0))
						return con;
					else {
						generateConnection();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		return con;
	}
}
