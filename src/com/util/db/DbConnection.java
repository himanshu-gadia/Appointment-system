package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnection {
		private final static String DRIVER_CLASS= "oracle.jdbc.driver.OracleDriver"; 
		private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		private final static String USER = "Name"; // add username
		private final static String PASSWORD = "pass"; // add password
		private static boolean isDriverLoaded = false;
		
		private DbConnection() {
			
		}//constructor

		static{
			 try{
				Class.forName(DRIVER_CLASS);
				System.out.println("Driver loaded successfully");
				isDriverLoaded = true;
				}catch(ClassNotFoundException e){
				System.out.println("driver loading error" + e);
				}
		}//static
		
		public static Connection getConnection() throws SQLException{
			Connection con = null;
			if(isDriverLoaded){
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			}
			return con;
		}//getConnection
		
		public static void closeConnection(Connection con) throws SQLException{
			if(con!=null){
				con.close();
			}
		}//closeConnection
}
