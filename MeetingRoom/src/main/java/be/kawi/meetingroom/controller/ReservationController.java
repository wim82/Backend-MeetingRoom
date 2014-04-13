package be.kawi.meetingroom.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.exceptions.data.Message;
import be.kawi.meetingroom.json.DateUtil;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.json.MeetingRoomJSON;
import be.kawi.meetingroom.json.ReservationJSON;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.service.ReservationService;
import be.kawi.meetingroom.service.UserService;

@Path("reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService userService;

	/**
	 * Creates new reservation
	 * 
	 * @param takes in a json representaiton of a reservation
	 * @returna json representation of the new reservation
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createReservation(ReservationJSON reservationJSON) {

		JSONWrapper jsonData = new JSONWrapper();
		ReservationJSON result;

		try {
			// TODO: turn this try block into one method (with only one database
			// call)
			Reservation reservation = reservationService.createReservation(reservationJSON.convertToReservation());

			result = new ReservationJSON(reservationService.getReservation(reservation.getReservationId()));

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(result);
		return Response.status(200).entity(jsonData).build();

	}

	/**
	 * Returns all reservations, ever, both active and non active
	 * 
	 * @return
	 */
	@GET
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

	/**
	 * Gets all reservations ever for a certain MeetingRoom
	 * 
	 * @param roomId
	 * @return
	 */
	@GET
	@Path("meetingroom/{roomId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservationByRoomId(@PathParam(value = "roomId") Integer roomId) {
		System.out.println("IN DE JUISTE CONTROLLER MET roomID:  " + roomId);
		JSONWrapper jsonData = new JSONWrapper();
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<ReservationJSON> jsonReservations = new ArrayList<ReservationJSON>();

		try {
			reservations = reservationService.getReservationByRoomId(roomId);
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
	
	/**
	 * Gets all reservations ever for a certain User
	 * 
	 * @param roomId
	 * @return
	 */
	@GET
	@Path("user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservationByUserId(@PathParam(value = "userId") Integer userId) {
		System.out.println("IN DE JUISTE CONTROLLER MET userId:  " + userId);
		JSONWrapper jsonData = new JSONWrapper();
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<ReservationJSON> jsonReservations = new ArrayList<ReservationJSON>();
		
		try {
			reservations = reservationService.getReservationByUserId(userId);
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


	/**
	 * 
	 * Gets all reservations ever for a certain MeetingRoom, starting at a date
	 * for an amount of days
	 * 
	 * @param roomId
	 * @return
	 */

	@GET
	@Path("meetingroom/{roomId}/{date}/{amountOfDays}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservationByRoomAndDate(@PathParam(value = "roomId") Integer roomId,
			@PathParam(value = "date") String date, @PathParam(value = "amountOfDays") Integer amountOfDays) {

		DateTime startDate = DateUtil.getDateTimeFromString(date);

		JSONWrapper jsonData = new JSONWrapper();
		List<Reservation> reservations = new ArrayList<Reservation>();
		List<ReservationJSON> jsonReservations = new ArrayList<ReservationJSON>();

		try {
			reservations = reservationService.getReservations(roomId, startDate, amountOfDays);
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
	
	/**
	 * 
	 * Gets all occupied meetingRooms for a specific startDate and endDate 
	 * 
	 * example: http://localhost:8080/meetingRoom/data/reservations/meetingrooms/20140509%2008:00/20140509%2016:45
	 * 
	 * @param startDate endDate
	 * @return
	 */
	
	@GET
	@Path("meetingrooms/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOccupiedMeetingRooms(@PathParam(value = "startDate") String startDate,@PathParam(value = "endDate") String endDate) {
		
		DateTime startDateTime = DateUtil.getLongDateTimeFromString(startDate);
		DateTime endDateTime = DateUtil.getLongDateTimeFromString(endDate);

		JSONWrapper jsonData = new JSONWrapper();
		List<MeetingRoom> occupiedMeetingRooms = new ArrayList<MeetingRoom>();
		List<MeetingRoomJSON> jsonMeetingRooms = new ArrayList<MeetingRoomJSON>();

		try {
			occupiedMeetingRooms = reservationService.getOccupiedMeetingRooms(startDateTime, endDateTime);
			for (MeetingRoom meetingRoom : occupiedMeetingRooms) {
				jsonMeetingRooms.add(new MeetingRoomJSON(meetingRoom));
			}

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(jsonMeetingRooms);
		return Response.status(200).entity(jsonData).build();

	}

	/**
	 * Deletes a reservation by its id
	 * 
	 * @param reservationId
	 * @return
	 */
	@DELETE
	@Path("{reservationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReservation(@PathParam(value = "reservationId") Integer reservationId) {

		JSONWrapper jsonData = new JSONWrapper();

		try {
			reservationService.deleteReservation(reservationId);
			jsonData.addMessage(new Message("The reservation has succesfully been deleted"));
			jsonData.addData(reservationId);

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		return Response.status(200).entity(jsonData).build();

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReservation(ReservationJSON reservationJSON) {

		System.out.println("hopla in de juste forever! met " + reservationJSON.getId());
		JSONWrapper jsonData = new JSONWrapper();
		ReservationJSON result;

		try {
			// TODO: turn this try block into one method (with only one database
			// call)

			Reservation reservation = reservationService.updateReservation(reservationJSON.convertToReservation());

			result = new ReservationJSON(reservationService.getReservation(reservation.getReservationId()));

		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(result);
		return Response.status(200).entity(jsonData).build();

	}

}
