package be.kawi.meetingroom.exceptions;


import javax.ws.rs.WebApplicationException;

import be.kawi.meetingroom.exceptions.data.Message;

public class MeetingRoomException extends RuntimeException {


    private Message msg;

    public MeetingRoomException(String message) {
        super(message);
    }

    public MeetingRoomException(Message msg) {
        super();
        this.msg = msg;
    }

    public MeetingRoomException() {
        super();

    }

    public Message getCustomMessage() {
        if (msg == null) {
            msg = new Message("REALLY BAD EXCEPTION WE DID NOT ACCOUNT FOR, SORRY!");
        }
        return msg;
    }

}
