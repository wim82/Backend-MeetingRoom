 package be.kawi.meetingroom.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus.Series;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;

public class ReservationJSON {

	private Integer id;
	private UserJSON user;
	private MeetingRoomJSON meetingRoom;
	
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

	public ReservationJSON(Reservation reservation) {
		this.id = reservation.getReservationId();
		this.user = new UserJSON(reservation.getUser());
		this.meetingRoom = new MeetingRoomJSON(reservation.getMeetingRoom());
		this.reservationDate = reservation.getReservationDate().toDate();
		this.reservationStartTime = reservation.getReservationStartTime()
				.toDate();
		this.reservationEndTime = reservation.getReservationEndTime()
				.toDate();
		this.reservationDescription = reservation.getReservationDescription();
	}
	
	public ReservationJSON() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserJSON getUser() {
		return user;
	}

	public void setUser(UserJSON user) {
		this.user = user;
	}

	public MeetingRoomJSON getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoomJSON meetingRoom) {
		this.meetingRoom = meetingRoom;
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
	
	public Reservation convertToReservation(){
		Reservation reservation = new Reservation();
	
		reservation.setReservationDescription(getReservationDescription());
		reservation.setReservationDate(new DateTime(getReservationDate()));
		reservation.setReservationStartTime(new DateTime(getReservationStartTime()));
		reservation.setReservationEndTime(new DateTime(getReservationEndTime()));
		reservation.setActive("Y");
		
		reservation.setMeetingRoom(new MeetingRoom(getMeetingRoom().getRoomId()));
		
		reservation.setUser(new User(getUser().getUserId()));

		
		return reservation;
	}
	

}
