package be.kawi.meetingroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.MeetingRoom;

@Repository
public class MeetingRoomDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<MeetingRoom> getMeetingRooms() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MeetingRoom.class);
		criteria.add(Restrictions.eq("active",true));
		criteria.addOrder(Order.asc("roomName"));
		return criteria.list();
	}

	public List<MeetingRoom> getMeetingRoom(MeetingRoom meetingRoom) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MeetingRoom.class);
		criteria.add(Restrictions.eq("roomId", meetingRoom.getRoomId()));
		criteria.add(Restrictions.eq("active",true));
		criteria.addOrder(Order.asc("roomName"));
		return criteria.list();
	}

	public void updateMeetingRoom(MeetingRoom meetingRoom) {
		sessionFactory.getCurrentSession().update(meetingRoom);
	}

	public void saveMeetingRoom(MeetingRoom meetingRoom) {
		sessionFactory.getCurrentSession().persist(meetingRoom);
	}

}
