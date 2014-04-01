package be.kawi.meetingroom.exceptions;

import be.kawi.meetingroom.exceptions.data.Message;

public class CorruptDatabaseException extends MeetingRoomException {
    public CorruptDatabaseException(String message) {
       super(new Message("There is something wrong in the database, I can't be more specific right now."));
  }
}