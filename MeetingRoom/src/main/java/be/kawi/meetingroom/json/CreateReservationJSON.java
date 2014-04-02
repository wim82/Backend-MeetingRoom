package be.kawi.meetingroom.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpStatus.Series;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;


public class CreateReservationJSON {

	private Integer id;
	private Integer userId;
	private String roomName;
	
	@JsonSerialize(using=ShortDateSerializer.class)
	@JsonDeserialize(using=ShortDateDeserializer.class)
	private Date reservationDate;
	
	@JsonSerialize(using=TimeSerializer.class)
	@JsonDeserialize(using=TimeDeserializer.class)
	private Date reservationStartTime;
	
	@JsonSerialize(using=TimeSerializer.class)
	@JsonDeserialize(using=TimeDeserializer.class)
	private Date reservationEndTime;
	private String reservationDescription;

	public CreateReservationJSON() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(Date reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public Date getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(Date reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}

	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
	}

	

}

