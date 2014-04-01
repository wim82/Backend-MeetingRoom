package be.kawi.meetingroom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.ReservationDAO;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;

@Service
public class ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Autowired
	private MeetingRoomService meetingRoomService;
	
	@Autowired
	private UserService userService;
	
	
	@Transactional
	public void createReservation() {
		
		Reservation reservation = new Reservation();

				   
		reservation.setReservationDate(new DateTime(2014,05,06,0,0));
		reservation.setReservationStartTime(new DateTime(1970,1,1,10,0,0));
		reservation.setReservationEndTime(new DateTime(1970,1,1,14,0,0));
		
		reservation.setActive("Y");
		System.out.println("START TIJD" + reservation.getReservationStartTime().toString());
		
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomName("China");
		meetingRoom.setRoomId(1);
		meetingRoom.setBuildingName("main");
		meetingRoom.setActive("Y");
		
		reservation.setMeetingRoom(meetingRoom);
		
		User user=new User();
		user.setUserId(3);
		user.setFullName("test");
		user.setUserName("test");
		user.setPassword("test");
		user.setActive("Y");
		
		reservation.setUser(user);
		
		reservation.setReservationDescription("dit is een test");
		
	
		reservationDAO.saveReservation(reservation);
		
	}


	
	
	
	
	
	
	
}
