package be.kawi.meetingroom.json;

import be.kawi.meetingroom.model.MeetingRoom;

public class MeetingRoomJSON {

	private Integer roomId;
	private String roomName;
	private String buildingName;
	
	public MeetingRoomJSON(MeetingRoom meetingRoom) {
		this.roomId=meetingRoom.getRoomId();
		this.roomName=meetingRoom.getRoomName();
		this.buildingName=meetingRoom.getBuildingName();
		
	}
	
	public MeetingRoomJSON(){
		super();
	}
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	
	
}
