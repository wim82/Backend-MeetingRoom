package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.json.MeetingRoomJSON;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.User;
import be.kawi.meetingroom.service.MeetingRoomService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("meetingrooms")
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMeetingRooms() {
    	
		JSONWrapper jsonData = new JSONWrapper();
		List<MeetingRoom> meetingRooms;
		List<MeetingRoomJSON> result = new ArrayList<MeetingRoomJSON>();

		try {
			meetingRooms = meetingRoomService.getMeetingRooms();
			for (MeetingRoom meetingRoom : meetingRooms){
				result.add(new MeetingRoomJSON(meetingRoom));
			}
		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(result);
		return Response.status(200).entity(jsonData).build();

    }
}
