package com.san.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.san.app.AppException;
import com.san.model.Auth;
import com.san.model.Reservation;
import com.san.util.Dbutil;

public class ReservationDao {
	public List<Reservation> getAllReservations() throws AppException
	{
    ArrayList<Reservation> ReservationList=new ArrayList<Reservation>();
   Connection con=Dbutil.connecttoDB();
   Reservation reservation=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   try {
	ps=con.prepareStatement("select * from Reservation");
	rs=ps.executeQuery();
	while(rs.next())
	{
		reservation=new Reservation();
		
		reservation.setGuestName(rs.getString("GuestName"));
		reservation.setReservationDate(rs.getString( "ReservationDate"));
		reservation.setReservationTime(rs.getString("ReservationTime"));
		reservation.setPhoneNo(rs.getString( "phoneNo"));
		reservation.setEmail(rs.getString( "Email"));
		reservation.setOccasion(rs.getString( "Occasion"));
		reservation.setGuestSize(rs.getInt( "GuestSize"));
		reservation.setConfirmationCode(rs.getInt( "ConfirmationCode"));
		reservation.setTableNo(rs.getInt("tableid"));
		ReservationList.add(reservation);
		
	
		
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException("error in fetching records from database", e.getCause());
}
  finally
  {
	  Dbutil.closeResources(ps, rs, con);
  }
   
   
    
    return ReservationList;
	}
	public Reservation getReservationId(int reservationId) throws AppException
	{
   // ArrayList<Reservation> ReservationList=new ArrayList<Reservation>();
   Connection con=Dbutil.connecttoDB();
   Reservation reservation=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   
   try {
	ps=con.prepareStatement("select * from Reservation where ConfirmationCode=?");
	ps.setInt(1,reservationId);
	rs=ps.executeQuery();
	while(rs.next())
	{
		reservation=new Reservation();
		reservation.setGuestName(rs.getString("GuestName"));
		reservation.setReservationDate(rs.getString( "ReservationDate"));
		reservation.setReservationTime(rs.getString("ReservationTime"));
		reservation.setPhoneNo(rs.getString( "phoneNo"));
		reservation.setEmail(rs.getString( "Email"));
		reservation.setOccasion(rs.getString( "Occasion"));
		reservation.setGuestSize(rs.getInt( "GuestSize"));
		reservation.setConfirmationCode(rs.getInt( "ConfirmationCode"));
		reservation.setTableNo(rs.getInt("tableid"));
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException("error in fetching records from database", e.getCause());
}
   
   
    
    return reservation;
	}


	public Reservation makeReservation(Reservation makeResevertaion) throws AppException
	{
	
		System.out.println(" In make Reservation");
		
   Connection con=Dbutil.connecttoDB();
 
   PreparedStatement ps=null;
   PreparedStatement psTable=null;
   ResultSet rs=null;
   int AvailableTable=0; 
   	 String guestName=makeResevertaion.getGuestName();
	 String ReservationDate=makeResevertaion.getReservationDate();
	 String ReservationTime=makeResevertaion.getReservationTime();
	 String phoneNo=makeResevertaion.getPhoneNo();
	 String Email=makeResevertaion.getEmail();
	 String occasion=makeResevertaion.getOccasion();
	 int guestSize=makeResevertaion.getGuestSize();
	 int ConfirmationCode=makeResevertaion.getConfirmationCode();
	 int tableNo=makeResevertaion.getTableNo();
	 String reservationStatus=null;
	 int sucess=0;
	 System.out.println("make reservation"+makeResevertaion.toString());
   try {
	   
	   psTable=con.prepareStatement("select tableid from tablestructure where status='empty' and size>=? "+"limit 1");
	    psTable.setInt(1,guestSize);
	   
	   rs=psTable.executeQuery();
	   if(rs.next())
	   {
		   AvailableTable=rs.getInt(1);
	   }
	   if(AvailableTable>0)
	   {
	ps=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?)",   PreparedStatement.RETURN_GENERATED_KEYS);
	ps.setString(1, guestName);
	ps.setString(2, ReservationDate);
	ps.setString(3, ReservationTime);
	ps.setString(4, phoneNo);
	ps.setString(5, Email);
	ps.setInt(6, guestSize);
	ps.setInt(7, ConfirmationCode);
	ps.setString(8, occasion);
	ps.setInt(9, AvailableTable);
	sucess=ps.executeUpdate();
	rs=ps.getGeneratedKeys();
	if(rs.next())
	{
		makeResevertaion.setConfirmationCode(rs.getInt(1));
	}
	
	   }
	if(sucess>0)
	{
		reservationStatus="Your Reservation is Made. You can come to restuarant at that Your Reserved Time";
		psTable=con.prepareStatement("update tablestructure set status='reserved' where tableid="+AvailableTable);
		psTable.executeUpdate();
	}
	else
	{
		reservationStatus="No Table is available at that Time. Please Modify the Time.";	
	}
	
}
	   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	
	  
} return makeResevertaion;
}
	
	public String deleteReservation(int confirmationCode) throws AppException  
	{
		Connection con = Dbutil.connecttoDB();
		String deleteStatus=null;
		PreparedStatement ps = null;
		int status=0;
		
		try {
			ps=con.prepareStatement("delete from reservation where confirmationCode=?");
			ps.setInt(1, confirmationCode);
			status=ps.executeUpdate();
			if(status>0)
			{
				deleteStatus="reservation has been deleted";
			ps=con.prepareStatement("update tablestructure t,reservation r set status='empty' where t.tableid!=r.tableid" );
			ps.execute();
	
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("error in fetching records from database", e.getCause());
			}
		}
		return deleteStatus;
		
		
	}
	
	public boolean authenticated(Auth auth) {
		// TODO Auto-generated method stub
		return false;
	}



}
