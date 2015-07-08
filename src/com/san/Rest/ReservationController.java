package com.san.Rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;






import com.san.app.AppException;
import com.san.dao.ReservationDao;
import com.san.model.Auth;
import com.san.model.Reservation;
@Path("/Reservation")

public class ReservationController {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
		
	public AppResponse getAll()
	{
		AppResponse resp=new AppResponse();
	
	try {
		ReservationDao reservationsmade=new ReservationDao();
		List<Reservation> reslist= reservationsmade.getAllReservations();
		resp.setStatus("sucess");
		resp.setPayLoad(reslist);
	} catch (AppException e) {
		// TODO Auto-generated catch block
		resp.setStatus("failure");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}	
	return resp;
	}
	@GET
	@Path("/resrvationId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		
	public AppResponse getReservation(@PathParam("id") int reservationId)
	{
		AppResponse resp=new AppResponse();
	/*	ReservationDao reservationsmade=new ReservationDao();
		Reservation reservationsDetails=reservationsmade.getReservationId(reservationId);
		resp.setStatus("sucess");
		resp.setPayLoad(reservationsDetails);*/

		ReservationDao reservationsmade=new ReservationDao();
		Reservation reservationsDetails;
		try {
			reservationsDetails = reservationsmade.getReservationId(reservationId);
			resp.setStatus("sucess");
			resp.setPayLoad(reservationsDetails);	
		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
	return resp;
	}
	@DELETE
	@Path("/delete/{confirmationCode}")
	//@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse deleteReservation(@PathParam("confirmationCode") int  confirmationCode) {

		AppResponse resp=new AppResponse();
		ReservationDao ReservationInfo = new ReservationDao();
		String deleteInfo=null;
		
		
		try {
			
			deleteInfo =ReservationInfo.deleteReservation(confirmationCode);
			resp.setMessage("deleted sucessfully");
			resp.setPayLoad(deleteInfo);
			
		} catch (AppException ae) {
resp.setStatus(AppResponse.ERROR);
resp.setMessage(ae.getMessage());
			ae.printStackTrace();
			//appResponse.setStatus(AppResponse.ERROR);
			//appResponse.setMessage(ae.getMessage());
		}
		return resp;
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation Res)
	{
		System.out.println(" adding reservation in");
		AppResponse resp=new AppResponse();
	
	try {
		ReservationDao reservationsmade=new ReservationDao();
		 Res= reservationsmade.makeReservation(Res);
		resp.setStatus("Reservation has been made");
		resp.setPayLoad(Res);
	} catch (AppException e) {
		// TODO Auto-generated catch block
		resp.setStatus("reservation is not done");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}	
	return resp;
	}
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AppResponse login(Auth auth)
	{
		AppResponse resp=new AppResponse();
		ReservationDao dao=new ReservationDao();
		boolean isAuthenticated=dao.authenticated(auth);
		if(isAuthenticated){
			resp.setMessage("login succesful");
		}else{
			resp.setMessage("login invalid");
		}
		return resp;
		
		
	}


}
