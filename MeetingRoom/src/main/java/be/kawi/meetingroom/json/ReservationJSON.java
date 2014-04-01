package be.kawi.meetingroom.json;

public class ReservationJSON {

	private Integer userId;
	private Integer roomId;
	private String reservationDate;
	private String reservationStartTime;
	private String reservationEndTime;
	private String reservationDescription;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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
