package be.kawi.meetingroom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;

	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	private MeetingRoom meetingRoom;

//	@Column(name = "RESERVATION_DATE")
//	@Temporal(value = TemporalType.DATE)
//	private Date date;

	@Column(name = "RESERVATION_STARTTIME")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date startTime;

	@Column(name = "RESERVATION_ENDTIME")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endTime;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "RESERVATION_DESCRIPTION")
	private String description;

	@Column(name = "ACTIVE")
	private Boolean active;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

/*	public DateTime getDate() {
		if (date != null) {
			// new DateTime(date) would return the current date when (date ==
			// null). We don't want that.
			return new DateTime(date);
		} else {
			return null;
		}
	}

	public void setDate(DateTime date) {
		this.date = date.toDate();
	}
*/
	
	public DateTime getStartTime() {
		if (startTime != null) {
			// new DateTime(date) would return the current date when (date ==
			// null). We don't want that.
			System.out.println(new DateTime(startTime));
			return new DateTime(startTime);

		} else {
			return null;
		}
	}

	public void setStartTime(DateTime startTime) {

		System.out.println("DATETIME ALS EM IN SETTER BINNENKOMT: " + startTime.toString());
		this.startTime = startTime.toDate();

		System.out.println("STARTTIJD IN SETTER" + this.startTime.toString());
	}

	public DateTime getEndTime() {
		if (endTime != null) {
			// new DateTime(date) would return the current date when (date ==
			// null). We don't want that.
			return new DateTime(endTime);
		} else {
			return null;
		}
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime.toDate();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
