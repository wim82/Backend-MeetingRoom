package be.kawi.meetingroom.service;




import be.kawi.meetingroom.dao.MeetingRoomDAO;
import be.kawi.meetingroom.dao.PublicHolidayDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchFullNameException;
import be.kawi.meetingroom.exceptions.NoSuchMeetingRoomException;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.PublicHoliday;
import be.kawi.meetingroom.model.User;

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
    
	@Transactional
	public MeetingRoom getMeetingRoom(Integer roomId) {
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomId(roomId);
		
		List<MeetingRoom> possibleMeetingRooms = meetingRoomDAO.getMeetingRoom(meetingRoom);

		if (possibleMeetingRooms.isEmpty()) {
			throw new NoSuchMeetingRoomException();
		}

		if (possibleMeetingRooms.size() > 1) {
			throw new CorruptDatabaseException(
					"There are 2 meeting rooms with the same id in the database");
		}

		MeetingRoom result = possibleMeetingRooms.get(0);
		return result;

	}

}
