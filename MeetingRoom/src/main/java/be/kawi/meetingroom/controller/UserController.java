package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.model.User;
import be.kawi.meetingroom.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllProducts() {
        return userService.getUsers();
    }
}
