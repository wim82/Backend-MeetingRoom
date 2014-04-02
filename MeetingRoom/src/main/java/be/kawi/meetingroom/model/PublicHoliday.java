package be.kawi.meetingroom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PUBLICHOLIDAYS")
public class PublicHoliday {

	@Id
	@Column(name = "HOLIDAY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer holidayId;

	@Column(name = "HOLIDAY_NAME")
	private String holidayName;

	@Column(name = "HOLIDAY_DATE")
	@Temporal(value = TemporalType.DATE)
	private Date holidayDate;

	public Integer getId() {
		return holidayId;
	}

	public void setId(Integer id) {
		this.holidayId = id;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

}
