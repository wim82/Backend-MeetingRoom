package be.kawi.meetingroom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.json.ReservationJSON;
import be.kawi.meetingroom.json.UserJSON;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;
import be.kawi.meetingroom.service.ReservationService;
import be.kawi.meetingroom.service.UserService;

@Path("reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createReservation(ReservationJSON reservationJSON) {

		JSONWrapper jsonData = new JSONWrapper();
		ReservationJSON result;

		try {
			//TODO: turn this try block into one method (with only one database call)
			Reservation reservation = reservationService.createReservation(reservationJSON.convertToReservation());
			
			result = new ReservationJSON(
					reservationService.getReservation(reservation.getReservationId()));

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(result);
		return Response.status(200).entity(jsonData).build();

	}

	
	
	@POST
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReservations() {
		JSONWrapper jsonData = new JSONWrapper();
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<ReservationJSON> jsonReservations = new ArrayList<ReservationJSON>();

		try {
			reservations = reservationService.getAllReservations();
			for (Reservation reservation : reservations) {
				jsonReservations.add(new ReservationJSON(reservation));
			}

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(jsonReservations);
		return Response.status(200).entity(jsonData).build();

	}

}
