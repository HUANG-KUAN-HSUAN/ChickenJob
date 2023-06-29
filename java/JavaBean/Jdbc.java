package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	String url = "jdbc:mysql://localhost:8888/JavaBean";
	String username = "root";
	String pass = "1234";
	
	public Jdbc() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
	public Connection get_Connection() throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, username, pass);
		return conn;
	}
}
