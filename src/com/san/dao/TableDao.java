package com.san.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.san.app.AppException;
import com.san.model.Table;
import com.san.util.Dbutil;

public class TableDao {
	public List<Table> getAllTables() throws AppException
	{
    ArrayList<Table> tableList=new ArrayList<Table>();
   Connection con=Dbutil.connecttoDB();
  Table table=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   try {
	ps=con.prepareStatement("select * from tablestructure");
	rs=ps.executeQuery();
	while(rs.next())
	{
		table=new Table();
		
		/*table.setGuestName(rs.getString("GuestName"));
		table.settableDate(rs.getString( "tableDate"));
		table.settableTime(rs.getString("tableTime"));
		table.setPhoneNo(rs.getString( "phoneNo"));
		table.setEmail(rs.getString( "Email"));
		table.setOccasion(rs.getString( "Occasion"));
		table.setGuestSize(rs.getInt( "GuestSize"));
		table.setConfirmationCode(rs.getInt( "ConfirmationCode"));
		table.setTableNo(rs.getInt("tableid"));
		tableList.add(table);*/
		table.setTableId(rs.getInt("tableid"));
		table.setSize(rs.getInt("size"));
		table.setStatus(rs.getString("status"));
		tableList.add(table);
		
		
	
		
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException("error in fetching records from database", e.getCause());
}
   
   
    
    return tableList;
	}

}
