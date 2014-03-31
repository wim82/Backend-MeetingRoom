package be.kawi.meetingroom.service;




import be.kawi.meetingroom.dao.MeetingRoomDAO;
import be.kawi.meetingroom.dao.PublicHolidayDAO;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.PublicHoliday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingRoomService {


    @Autowired
    private MeetingRoomDAO meetingRoomDAO;

    
    @Transactional
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRoomDAO.getMeetingRooms();
    }

}
