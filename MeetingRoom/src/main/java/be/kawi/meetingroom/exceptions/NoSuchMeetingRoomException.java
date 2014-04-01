package be.kawi.meetingroom.exceptions;

public class NoSuchMeetingRoomException extends MeetingRoomException {
    public NoSuchMeetingRoomException() {
        super("MeetingRoom is not known in the database");  
  }
}
