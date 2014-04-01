package be.kawi.meetingroom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;


@Repository
public class ReservationDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void saveReservation (Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
	}	
	
	public List<Reservation> getAllReservations() {
        return sessionFactory.getCurrentSession().createCriteria(Reservation.class).list();
    }
	
}
