package be.kawi.meetingroom.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.Reservation;


@Repository
public class ReservationDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void saveReservation (Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
	}
	
	public Reservation getReservation (int reservationId){
		return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class,reservationId);
	}
	
}
