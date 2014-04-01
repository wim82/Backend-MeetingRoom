package be.kawi.meetingroom.json;

import be.kawi.meetingroom.model.MeetingRoom;
import be.kawi.meetingroom.model.Reservation;
import be.kawi.meetingroom.model.User;

public class ReservationJSON {

	private Integer id;
	private UserJSON userJSON;
	private MeetingRoomJSON meetingRoomJSON;
	private String reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
	private String reservationDescription;

	public ReservationJSON(Reservation reservation) {
		this.id = reservation.getReservationId();
		this.userJSON = new UserJSON(reservation.getUser());
		this.meetingRoomJSON = new MeetingRoomJSON(reservation.getMeetingRoom());
		this.reservationDate = reservation.getReservationDate().toString();
		this.reservationStartTime = reservation.getReservationStartTime()
				.toString();
		this.reservationEndTime = reservation.getReservationEndTime()
				.toString();
		this.reservationDescription = reservation.getReservationDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserJSON getUserJSON() {
		return userJSON;
	}

	public void setUserJSON(UserJSON userJSON) {
		this.userJSON = userJSON;
	}

	public MeetingRoomJSON getMeetingRoomJSON() {
		return meetingRoomJSON;
	}

	public void setMeetingRoomJSON(MeetingRoomJSON meetingRoomJSON) {
		this.meetingRoomJSON = meetingRoomJSON;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public String getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(String reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}

	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
	}

}
