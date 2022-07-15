package com.subin.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	//Define the Database Properties
	private static final String URL = "jdbc:mysql://localhost:3306/newhotelbookingsystem";

	private static final String USERNAME = "hotelbookingsystemuser";

	private static final String PASSWORD = "root123";

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Connection con;


	//Define the static method
	public static Connection openConnection(){

		//Check the connection and if already availabe return that connection
		if(con!=null)
			return con;

		else
		{
			try {
				//Load the driver
				Class.forName(DRIVER);

				//Get the Connection
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (Exception e) {

				e.printStackTrace();
			}

			//Return the Connection
			return con;		

		}


	}

}
