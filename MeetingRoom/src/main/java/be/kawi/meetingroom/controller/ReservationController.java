package be.kawi.meetingroom.controller;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
		
			
		reservationService.createReservation();
		
	}
	
}
