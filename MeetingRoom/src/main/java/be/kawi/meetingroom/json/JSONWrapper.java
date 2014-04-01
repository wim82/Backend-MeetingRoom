package be.kawi.meetingroom.json;

import java.util.ArrayList;
import java.util.List;

import be.kawi.meetingroom.exceptions.data.Message;

public class JSONWrapper {

    private List<Message> messages;
    private Object data;

    public JSONWrapper() {
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public void addData(Object data) {
        this.data = data;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Object getData() {
        return data;
    }

}
