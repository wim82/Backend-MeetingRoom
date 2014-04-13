package be.kawi.meetingroom.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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

	public List<Reservation> getReservations(Reservation reservation) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("active",true));
		if (reservation.getReservationId() != null) {
			criteria.add(Restrictions.eq("reservationId", reservation.getReservationId()));
		}
		return criteria.list();
	}

	//FIX THIS
	public List<Reservation> getReservations(MeetingRoom room, Date startDate, Date endDate) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);

		criteria.add(Restrictions.eq("active",true));
		if (room != null) {
			criteria.add(Restrictions.eq("meetingRoom", room));
		}

		// note the ge & lt. they're intended
		criteria.add(Restrictions.ge("startTime", startDate));
		criteria.add(Restrictions.lt("endTime", endDate));
		criteria.addOrder(Order.asc("startTime"));

		return criteria.list();
	}
	
	public List<Reservation> getStartDateReservations(Date startDate){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.le("startTime", startDate));
		criteria.add(Restrictions.gt("endTime", startDate));
		
		return criteria.list();
	}
	
	public List<Reservation> getEndDateReservations(Date endDate){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.lt("startTime", endDate));
		criteria.add(Restrictions.ge("endTime", endDate));
		
		return criteria.list();
	}
	
	public List<Reservation> getMixedDateReservations(Date startDate, Date endDate){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.gt("startTime", startDate));
		criteria.add(Restrictions.lt("endTime", endDate));
		
		return criteria.list();
	}

	public List<Reservation> getReservationByRoom(MeetingRoom room) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.eq("meetingRoom", room));
		
		criteria.addOrder(Order.asc("startTime"));
		return criteria.list();
	}
	
	public List<Reservation> getReservationByUser(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.eq("user", user));
	
		criteria.addOrder(Order.asc("startTime"));
		return criteria.list();
	}

	public Reservation saveReservation(Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
		return reservation;
	}

	public List<Reservation> getAllReservations() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("active",true));
		//criteria.addOrder(Order.asc("date"));
		criteria.addOrder(Order.asc("startTime"));
		return criteria.list();
	}

}
