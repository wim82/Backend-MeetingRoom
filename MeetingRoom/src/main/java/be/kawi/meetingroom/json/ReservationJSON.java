package be.kawi.meetingroom.json;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;

public class ReservationJSON {

	private Integer id;
	private UserJSON user;
	private MeetingRoomJSON meetingRoom;

	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = ShortDateDeserializer.class)
	private Date date;

	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	private Date startTime;

	@JsonSerialize(using = TimeSerializer.class)
	@JsonDeserialize(using = TimeDeserializer.class)
	private Date endTime;

	private String description;

	public ReservationJSON(Reservation reservation) {
		this.id = reservation.getReservationId();
		this.user = new UserJSON(reservation.getUser());
		this.meetingRoom = new MeetingRoomJSON(reservation.getMeetingRoom());
		this.date = reservation.getDate().toDate();
		this.startTime = reservation.getStartTime().toDate();
		this.endTime = reservation.getEndTime().toDate();
		this.description = reservation.getDescription();
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date reservationDate) {
		this.date = reservationDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date reservationStartTime) {
		this.startTime = reservationStartTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date reservationEndTime) {
		this.endTime = reservationEndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String reservationDescription) {
		this.description = reservationDescription;
	}

	public Reservation convertToReservation() {
		Reservation reservation = new Reservation();
		reservation.setDescription(getDescription());
		reservation.setDate(new DateTime(getDate()));
		reservation.setStartTime(new DateTime(getStartTime()));
		reservation.setEndTime(new DateTime(getEndTime()));
		reservation.setActive(true);
		reservation.setReservationId(getId());

		reservation.setMeetingRoom(new MeetingRoom(getMeetingRoom().getRoomId()));
		reservation.setUser(new User(getUser().getUserId()));

		return reservation;
	}

}
