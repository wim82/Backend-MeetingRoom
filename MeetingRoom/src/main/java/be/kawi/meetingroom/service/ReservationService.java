package be.kawi.meetingroom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date reservationDate=new Date();
		try {
			reservationDate = newDateFormat.parse("01/04/2014");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat newTimeFormat = new SimpleDateFormat("hh:mm");
		Date reservationStartTime=new Date();
		try {
			reservationStartTime = newTimeFormat.parse("10:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date reservationEndTime=new Date();
		try {
			reservationEndTime = newTimeFormat.parse("11:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				   
		reservation.setReservationDate(reservationDate);
		reservation.setReservationStartTime(reservationStartTime);
		reservation.setReservationEndTime(reservationEndTime);
		
		reservation.setActive("Y");
		
		
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
