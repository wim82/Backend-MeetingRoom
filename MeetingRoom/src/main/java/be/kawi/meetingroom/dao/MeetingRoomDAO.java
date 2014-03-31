package be.kawi.meetingroom.dao;


import be.kawi.meetingroom.model.MeetingRoom;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MeetingRoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<MeetingRoom> getMeetingRooms() {
        return sessionFactory.getCurrentSession().createCriteria(MeetingRoom.class).list();
    }

    public void updateMeetingRoom(MeetingRoom meetingRoom) {
        sessionFactory.getCurrentSession().update(meetingRoom);
    }

    public void saveMeetingRoom(MeetingRoom meetingRoom) {
        sessionFactory.getCurrentSession().persist(meetingRoom);
    }

}
