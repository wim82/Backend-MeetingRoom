package be.kawi.meetingroom.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;




import be.kawi.meetingroom.service.ReservationService;


@Path("reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	
	@POST
	@Path("/create")
//	@Consumes(MediaType.APPLICATION_JSON)
	public void createReservation() {
		
			//testing github
		reservationService.createReservation();
		
	}
	
	@POST
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReservations(){
		
		return Response.ok().build();
	}
	
	
}
