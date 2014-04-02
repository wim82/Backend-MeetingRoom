package be.kawi.meetingroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEETINGROOMS")
public class MeetingRoom {

	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomId;

	@Column(name = "ROOM_NAME")
	private String roomName;

	@Column(name = "BUILDING")
	private String buildingName;

	@Column(name = "ACTIVE")
	private Boolean active;

	public MeetingRoom(Integer id) {
		this.roomId = id;
		this.roomName = null;
		this.buildingName = null;
		this.active = null;
	}

	public MeetingRoom() {

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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
