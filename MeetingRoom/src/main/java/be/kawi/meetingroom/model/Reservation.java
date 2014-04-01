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
		
		@Column(name = "RESERVATION_DATE")
		@Temporal(value = TemporalType.DATE)
		private Date reservationDate;

		@Column(name="RESERVATION_STARTTIME")
		@Temporal(value=TemporalType.DATE)
		private Date reservationStartTime;
		
		@Column(name="RESERVATION_ENDTIME")
		@Temporal(value=TemporalType.DATE)
		private Date reservationEndTime;
		
		@ManyToOne
	    @JoinColumn(name = "USER_ID")
	    private User user;
		
		@Column(name = "RESERVATION_DESCRIPTION")
		private String reservationDescription;
		
		@Column(name ="ACTIVE")
		private String active;

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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getReservationDescription() {
			return reservationDescription;
		}

		public void setReservationDescription(String reservationDescription) {
			this.reservationDescription = reservationDescription;
		}

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}

		

	}
