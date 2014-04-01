package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.exceptions.MeetingRoomException;
import be.kawi.meetingroom.json.JSONWrapper;
import be.kawi.meetingroom.json.UserJSON;
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
		List<UserJSON> usersJSON = new ArrayList<UserJSON>();

		try {
			users = userService.getUsers();
			for (User user : users) {
				usersJSON.add(new UserJSON(user));	
			}
		} catch (MeetingRoomException e) {
			jsonData.addMessage(e.getCustomMessage());
			return Response.status(412).entity(usersJSON).build();
		}

		jsonData.addData(users);
		return Response.status(200).entity(usersJSON).build();

	}
	
	
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserJSON userJSON) {
    	
        JSONWrapper jsonData = new JSONWrapper();
        UserJSON result;

        try {
        	result = new UserJSON(userService.login(userJSON.getFullName()));
        } catch (MeetingRoomException e) {
            jsonData.addMessage(e.getCustomMessage());
            return Response.status(412).entity(jsonData).build();
        }

        jsonData.addData(result);
        return Response.status(200).entity(jsonData).build();
      
    }
      
}
