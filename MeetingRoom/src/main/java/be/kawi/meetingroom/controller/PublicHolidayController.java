package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.PublicHoliday;
import be.kawi.meetingroom.service.PublicHolidayService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("publicholidays")
public class PublicHolidayController {

    @Autowired
    private PublicHolidayService publicHolidayService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPublicHolidays() {
		JSONWrapper jsonData = new JSONWrapper();
		List<PublicHoliday> publicHolidays = new ArrayList<PublicHoliday>();

		try {
			publicHolidays = publicHolidayService.getPublicHolidays();
		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(publicHolidays);
		return Response.status(200).entity(jsonData).build();
    }
}
