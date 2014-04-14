package be.kawi.meetingroom.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.ReservationDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchReservationException;
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
		return reservationDAO.saveReservation(reservation);
	}

	@Transactional
	public Reservation getReservation(Integer reservationId) {
		Reservation reservation = new Reservation();
		reservation.setReservationId(reservationId);
		return getReservation(reservation);
	}

	@Transactional
	public Reservation getReservation(Reservation reservation) {

		List<Reservation> possibleReservations = reservationDAO.getReservations(reservation);

		if (possibleReservations.isEmpty()) {
			throw new NoSuchReservationException();
		}

		if (possibleReservations.size() > 1) {
			throw new CorruptDatabaseException("There are 2 reservations with the same id in the database");
		}

		Reservation result = possibleReservations.get(0);

		return result;

	}

	@Transactional
	public List<Reservation> getAllReservations() {
		return reservationDAO.getAllReservations();
	}

	@Transactional
	public List<Reservation> getReservationByRoomId(Integer roomId) {
		MeetingRoom room = new MeetingRoom(roomId);
		return reservationDAO.getReservationByRoom(room);
	}

	@Transactional
	public List<Reservation> getReservationByUserId(Integer userId) {
		User user = new User(userId);
		return reservationDAO.getReservationByUser(user);
	}

	@Transactional
	public List<Reservation> getReservations(Integer roomId, DateTime date, Integer amountOfDays) {
		MeetingRoom room = new MeetingRoom(roomId);
		Date startDate = date.withTime(0, 0, 0, 0).toDate();
		Date endDate = date.withTime(0, 0, 0, 0).plusDays(amountOfDays).toDate();
		System.out.println("amount " + startDate + " " + endDate);

		return reservationDAO.getReservations(room, startDate, endDate);

	}

	@Transactional
	public List<MeetingRoom> getOccupiedMeetingRooms(DateTime startDateTime, DateTime endDateTime) {

		List<MeetingRoom> occupiedMeetingRooms = new ArrayList<MeetingRoom>();
		List<Reservation> reservations = new ArrayList<Reservation>();
		Date startDate = startDateTime.toDate();
		Date endDate = endDateTime.toDate();
		
		reservations = reservationDAO.getStartDateReservations(startDate);
		for (int i = 0; i < reservations.size(); i++) {
			MeetingRoom occupiedMeetingRoom = reservations.get(i).getMeetingRoom();
			if (!(occupiedMeetingRooms.contains(occupiedMeetingRoom))) {
				occupiedMeetingRooms.add(occupiedMeetingRoom);
			}
		}
		
		reservations = reservationDAO.getEndDateReservations(endDate);
		for (int i = 0; i < reservations.size(); i++) {
			MeetingRoom occupiedMeetingRoom = reservations.get(i).getMeetingRoom();
			if (!(occupiedMeetingRooms.contains(occupiedMeetingRoom))) {
				occupiedMeetingRooms.add(occupiedMeetingRoom);
			}
		}
		
		reservations = reservationDAO.getMixedDateReservations(startDate, endDate);
		for (int i = 0; i < reservations.size(); i++) {
			MeetingRoom occupiedMeetingRoom = reservations.get(i).getMeetingRoom();
			if (!(occupiedMeetingRooms.contains(occupiedMeetingRoom))) {
				occupiedMeetingRooms.add(occupiedMeetingRoom);
			}
		}

		return occupiedMeetingRooms;
	}
	
	@Transactional
	public List<MeetingRoom> getAvailableMeetingRooms(DateTime startDateTime, DateTime endDateTime) {
		
		List<MeetingRoom> occupiedMeetingRooms = getOccupiedMeetingRooms(startDateTime, endDateTime); 
		List<MeetingRoom> availableMeetingRooms = meetingRoomService.getMeetingRooms();
		
		availableMeetingRooms.removeAll(occupiedMeetingRooms);
		
		return availableMeetingRooms;
	}

	@Transactional
	public void deleteReservation(Integer reservationId) {
		System.out.println("deleteReservation");
		Reservation reservation = getReservation(reservationId);
		reservation.setActive(false);
		reservationDAO.saveReservation(reservation);
	}

	@Transactional
	public Reservation updateReservation(Reservation reservation) {
		System.out.println("updateReservation");
		deleteReservation(reservation.getReservationId()); // delete = set
															// active to false
		return reservationDAO.saveReservation(reservation); // create = new
															// reservation id
	}

}
