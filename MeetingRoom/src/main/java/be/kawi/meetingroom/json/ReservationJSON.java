package be.kawi.meetingroom.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;


public class ReservationJSON {

	private Integer id;
	private UserJSON user;
	private MeetingRoomJSON meetingRoom;
	private Date reservationDate;
	private Date reservationStartTime;
	private Date reservationEndTime;
	private String reservationDescription;

	public ReservationJSON(Reservation reservation) {
		this.id = reservation.getReservationId();
		this.user = new UserJSON(reservation.getUser());
		this.meetingRoom = new MeetingRoomJSON(reservation.getMeetingRoom());
		this.reservationDate = reservation.getReservationDate().toDate();
		System.out.println("reservationjson constructor "+reservation.getReservationDate().toDate().toString());
		this.reservationStartTime = reservation.getReservationStartTime()
				.toDate();
		this.reservationEndTime = reservation.getReservationEndTime()
				.toDate();
		this.reservationDescription = reservation.getReservationDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserJSON getUserJSON() {
		return user;
	}

	public void setUserJSON(UserJSON user) {
		this.user = user;
	}

	public MeetingRoomJSON getMeetingRoomJSON() {
		return meetingRoom;
	}

	public void setMeetingRoomJSON(MeetingRoomJSON meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	//@JsonSerialize(using=JsonDateSerializer.class)
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
