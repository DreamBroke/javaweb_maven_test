package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	
	private static String DB_DRIVER;
	
	private static String DB_URL;
	
	private static String DB_USERNAME;
	
	private static String DB_PASSWORD;
	
	private static Connection connection;
	
	static{
		Properties p = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			p.load(is);
			DB_DRIVER = p.getProperty("driver");
			DB_URL = p.getProperty("url");
			DB_USERNAME = p.getProperty("user");
			DB_PASSWORD = p.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection GetConnection(){
		if (connection == null) {
		    try {
	            Class.forName(DB_DRIVER);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return connection;
	}
	
}
