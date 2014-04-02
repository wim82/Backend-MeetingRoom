package be.kawi.meetingroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;


@Repository
public class ReservationDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
	
    public List<Reservation> getReservation(Reservation reservation) {
        //TODO: implement more criteria if needed
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
        criteria.add(Restrictions.eq("reservationId", reservation.getReservationId()));
        return criteria.list();
    }
    
	public Reservation saveReservation (Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
		return reservation;
	}	
	
	public List<Reservation> getAllReservations() {
        return sessionFactory.getCurrentSession().createCriteria(Reservation.class).list();
    }
	
}
