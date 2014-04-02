package be.kawi.meetingroom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.ReservationDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchFullNameException;
import be.kawi.meetingroom.json.CreateReservationJSON;
import be.kawi.meetingroom.json.ReservationJSON;
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
	public Reservation createReservation(Reservation reservation) {
		
		reservationDAO.saveReservation(reservation);
		
		//nog checks implementeren of de reservatie successfull is weggeschreven in de db
		
		return reservation;
		
	
	}
	
	
	@Transactional
	public Reservation createReservation(ReservationJSON reservationJSON) {
		
		Reservation reservation = new Reservation();
		
		reservation.setActive("Y");
		reservation.setReservationDescription(reservationJSON.getReservationDescription());
		
		System.out.println("print out what is the jsonreservation date:"+reservationJSON.getReservationDate().toString());
		Date date=reservationJSON.getReservationDate();
		DateTime dateTime=new DateTime(date);
		reservation.setReservationDate(dateTime);
		
		
		System.out.println("print out what is the jsonreservation starttime:"+reservationJSON.getReservationStartTime().toString());
		Date startTime=reservationJSON.getReservationStartTime();
		DateTime dateStartTime=new DateTime(startTime);
		reservation.setReservationStartTime(dateStartTime);
		
		Date endTime=reservationJSON.getReservationEndTime();
		DateTime dateEndTime=new DateTime(endTime);
		reservation.setReservationEndTime(dateEndTime);
		
		
		reservation.setMeetingRoom(new MeetingRoom(reservationJSON.getMeetingRoom().getRoomId()));
		/*MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomName("China");
		meetingRoom.setRoomId(1);
		meetingRoom.setBuildingName("main");
		meetingRoom.setActive("Y"); */
		
		//reservation.setMeetingRoom(meetingRoom);
		
		
		reservation.setUser(new User(reservationJSON.getUser().getUserId()));
		
	/*	User user=new User();
		user.setUserId(3);
		user.setFullName("test");
		user.setUserName("test");
		user.setPassword("test");
		user.setActive("Y");
		
		reservation.setUser(user);*/
		
		reservationDAO.saveReservation(reservation);
		
		//nu returned deze methode de reservatie die je hebt meegegeven met json
		
		return createReservation(reservation);
		
	}
		
		

	
	@Transactional
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
	
	
	
	
	
}
