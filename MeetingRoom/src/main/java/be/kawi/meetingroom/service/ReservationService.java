package be.kawi.meetingroom.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.ReservationDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchFullNameException;
import be.kawi.meetingroom.exceptions.NoSuchReservationException;
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
		return reservationDAO.saveReservation(reservation);
	}
	
	@Transactional
	public Reservation getReservation(Integer reservationId) {
		Reservation reservation = new Reservation();
		reservation.setReservationId(reservationId);
		List<Reservation> possibleReservations = reservationDAO.getReservation(reservation);

		if (possibleReservations.isEmpty()) {
			throw new NoSuchReservationException();
		}

		if (possibleReservations.size() > 1) {
			throw new CorruptDatabaseException(
					"There are 2 reservations with the same id in the database");
		}

		Reservation result = possibleReservations.get(0);
		System.out.println("IN RESEREVATION SERVICE: " + result);
		System.out.println("IN RESEREVATION SERVICE: " + result.getUser().getFullName());
		return result;

	}



	@Transactional
	public List<Reservation> getAllReservations() {
		return reservationDAO.getAllReservations();
	}

}
