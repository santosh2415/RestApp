package com.san.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbutil {
	private final static String url="jdbc:mysql://localhost:3306/Hotel";
	private final static String user="root";
	private final static String password="";
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static Connection connecttoDB()
{
	Connection con=null;
	try {
		con=DriverManager.getConnection(url, user, password);
		System.out.println("succesful");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
public static void closeResources(PreparedStatement ps,ResultSet rs,Connection con)
{
try {
	if(ps!=null)
	ps.close();
	if(rs!=null)
	rs.close();
	if(con!=null)
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}


}
