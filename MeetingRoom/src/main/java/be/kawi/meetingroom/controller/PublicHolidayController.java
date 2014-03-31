package be.kawi.meetingroom.controller;

import be.kawi.meetingroom.model.PublicHoliday;
import be.kawi.meetingroom.service.PublicHolidayService;


import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("publicholidays")
public class PublicHolidayController {

    @Autowired
    private PublicHolidayService publicHolidayService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PublicHoliday> getPublicHolidays() {
        return publicHolidayService.getPublicHolidays();
    }
}
