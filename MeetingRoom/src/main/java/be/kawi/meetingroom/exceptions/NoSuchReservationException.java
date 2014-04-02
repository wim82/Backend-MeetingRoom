package be.kawi.meetingroom.exceptions;

public class NoSuchReservationException extends MeetingRoomException {
	public NoSuchReservationException() {
		super("There is no such reservation in the database");
	}
}
