package be.kawi.meetingroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.kawi.meetingroom.dao.UserDAO;
import be.kawi.meetingroom.exceptions.CorruptDatabaseException;
import be.kawi.meetingroom.exceptions.NoSuchFullNameException;
import be.kawi.meetingroom.exceptions.NoSuchMeetingRoomException;
import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Transactional
	public User login(User user) {
		List<User> possibleUsers = userDAO.getUser(user);

		if (possibleUsers.isEmpty()) {
			throw new NoSuchFullNameException();
		}

		if (possibleUsers.size() > 1) {
			throw new CorruptDatabaseException("There are 2 users with the same name in the database");
		}

		User result = possibleUsers.get(0);
		return result;

	}

	@Transactional
	public User login(String fullName) {
		User user = new User();
		user.setFullName(fullName.trim());
		return login(user);
	}

	@Transactional
	public User getUserByFullName(String fullName) {
		User user = new User();
		user.setFullName(fullName.trim());
		
		List<User> possibleUsers = userDAO.getUser(user);
		

		//List<MeetingRoom> possibleMeetingRooms = meetingRoomDAO.getMeetingRoom(meetingRoom);

		if (possibleUsers.isEmpty()) {
			throw new NoSuchFullNameException();
		}

		if (possibleUsers.size() > 1) {
			throw new CorruptDatabaseException("There are 2 users with the same fullName in the database");
		}

		User result = possibleUsers.get(0);
		return result;

	}
	
}
