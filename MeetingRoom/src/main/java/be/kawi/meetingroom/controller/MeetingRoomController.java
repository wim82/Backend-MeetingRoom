package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.service.MeetingRoomService;


import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("meetingrooms")
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    //meeting room controlller
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRoomService.getMeetingRooms();
    }
}
