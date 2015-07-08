package com.san.Rest;

import com.san.app.AppException;
import com.san.dao.ReservationDao;
import com.san.model.Reservation;

public class A {

	public static void main(String[] args) throws AppException {
		// TODO Auto-generated method stub
		/*Reservation status=null;
		Reservation newReservation=new Reservation();
		newReservation.setGuestName("santosh");
		newReservation.setReservationDate("12-05-2015");
		newReservation.setReservationTime("8:00 AM");
		newReservation.setPhoneNo("704-904-1801");
		newReservation.setEmail("santosh@gmail.com");
		newReservation.setGuestSize(4);
	newReservation.setConfirmationCode(0);
		newReservation.setOccasion("Birthday");
		ReservationDao rc=new ReservationDao();
	status=rc.makeReservation(newReservation);*/
	//	System.out.println(status);
		ReservationDao d=new ReservationDao();
	 //d.makeReservation(newReservation);
	    d.deleteReservation(15);
	

}
}
