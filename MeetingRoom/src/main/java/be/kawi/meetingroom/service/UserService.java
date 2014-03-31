package be.kawi.meetingroom.service;




import be.kawi.meetingroom.dao.MeetingRoomDAO;
import be.kawi.meetingroom.dao.PublicHolidayDAO;
import be.kawi.meetingroom.dao.UserDAO;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.PublicHoliday;
import be.kawi.meetingroom.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserDAO userDAO;

    
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

}
