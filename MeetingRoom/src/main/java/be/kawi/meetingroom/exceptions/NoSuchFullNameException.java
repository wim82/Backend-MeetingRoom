package be.kawi.meetingroom.exceptions;

public class NoSuchFullNameException extends MeetingRoomException {
	public NoSuchFullNameException() {
		super("Username is not known by the given fullname");
	}
}