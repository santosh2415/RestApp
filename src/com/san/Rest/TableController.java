package com.san.Rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.san.app.AppException;
import com.san.dao.ReservationDao;
import com.san.dao.TableDao;
import com.san.model.Reservation;
import com.san.model.Table;
import com.san.app.*;
@Path("/Table")
public class TableController {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAllTables()
	{
		AppResponse resp=new AppResponse();
	
		TableDao tables=new TableDao();
		List<Table> tablelist;
		try {
			tablelist = tables.getAllTables();
			resp.setStatus("sucess");
			resp.setPayLoad(tablelist);
		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
			
		}
		
	
	
	
	return resp;
	}


}
/*public AppResponse getAll()
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
}*/