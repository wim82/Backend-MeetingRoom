package be.kawi.meetingroom.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;

@Repository
public class ReservationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Reservation> getReservations(Reservation reservation) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		if (reservation.getReservationId() != null) {
			criteria.add(Restrictions.eq("reservationId", reservation.getReservationId()));
		}
		return criteria.list();
	}

	public List<Reservation> getReservations(MeetingRoom room, Date startDate, Date endDate) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);

		if (room != null) {
			criteria.add(Restrictions.eq("meetingRoom", room));
		}

		// note the ge & lt. they're intended
		criteria.add(Restrictions.ge("date", startDate));
		criteria.add(Restrictions.lt("date", endDate));

		return criteria.list();
	}

	public List<Reservation> getReservationByRoom(MeetingRoom room) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("meetingRoom", room));
		return criteria.list();
	}

	public Reservation saveReservation(Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
		return reservation;
	}

	public List<Reservation> getAllReservations() {
		return sessionFactory.getCurrentSession().createCriteria(Reservation.class).list();
	}

}
