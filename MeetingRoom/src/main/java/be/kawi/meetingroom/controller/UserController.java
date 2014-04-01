package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.model.User;
import be.kawi.meetingroom.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("users")
public class UserController {

	@Autowired
	private UserService userService;

	/* EXPERIMENTAL FEATURE. MUST BE DELETED FOR PRODUCTION.
	 * 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {

		JSONWrapper jsonData = new JSONWrapper();

		List<User> users = new ArrayList<User>();

		try {
			users = userService.getUsers();
		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(jsonData).build();
		}

		jsonData.addData(users);
		return Response.status(200).entity(jsonData).build();

	}
	
	/*
    @POST
    @Path("check")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
    	
        JSONWrapper jsonData = new JSONWrapper();
       User verifiedUser;

      
        try {
        
        	verifiedUser = userService.login(user);
        } catch (PetException e) {
            jsonUser = new UserJSON();
            jsonData.addData(jsonUser);
            jsonData.addMessage(e.getCustomMessage());
            return Response.status(412).entity(jsonData).build();
        }

        jsonData.addData(jsonUser);
        return Response.ok(jsonData).build();
      
    }
      */
}
