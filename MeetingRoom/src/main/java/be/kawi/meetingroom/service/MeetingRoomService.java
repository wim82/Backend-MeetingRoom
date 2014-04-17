package be.kawi.meetingroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.MeetingRoomDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchMeetingRoomException;
import be.kawi.meetingroom.model.MeetingRoom;

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
			throw new CorruptDatabaseException("There are 2 meeting rooms with the same id in the database");
		}

		MeetingRoom result = possibleMeetingRooms.get(0);
		return result;

	}
	
	@Transactional
	public MeetingRoom getMeetingRoom(String roomName) {
	

		List<MeetingRoom> possibleMeetingRooms = meetingRoomDAO.getMeetingRoom(roomName);

		if (possibleMeetingRooms.isEmpty()) {
			throw new NoSuchMeetingRoomException();
		}

		if (possibleMeetingRooms.size() > 1) {
			throw new CorruptDatabaseException("There are 2 meeting rooms with the same name in the database");
		}

		MeetingRoom result = possibleMeetingRooms.get(0);
		return result;

	}


}
