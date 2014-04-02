package be.kawi.meetingroom.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";
	public static final String LONG_DATE_FORMAT = "EEEE dd MMMM yyyy";
	public static final String TIME_FORMAT = "HH:mm";

	/*
	 * Returns the next workday after today Sunday is not a workday
	 */
	public LocalDate nextWorkDay() {
		return nextWorkDay(new LocalDate());
	}

	/*
	 * Returns the next workday after date Sunday is not a workday
	 */
	public LocalDate nextWorkDay(LocalDate date) {
		LocalDate nextWorkDay = date.plusDays(1);

		if (nextWorkDay.dayOfWeek().get() == DateTimeConstants.SUNDAY) {
			nextWorkDay = nextWorkDay.plusDays(1);
		}

		return nextWorkDay;
	}

	public List<LocalDate> getDays(LocalDate from, int amountOfDays) {
		List<LocalDate> result = new ArrayList<LocalDate>();
		LocalDate aDay = from;

		for (int i = 0; i < amountOfDays; i++) {
			result.add(aDay);
			aDay = aDay.plusDays(1);
		}

		return result;
	}

	public Date convertLocalTimeToDate(LocalTime time) {
		// theBeginningOfTime references to 1-1-1970
		DateTime theBeginningOfTime = new DateTime(0);
		return time.toDateTime(theBeginningOfTime).toDate();
	}

	public Date addDays(Date date, int days) {
		LocalDate ld = new LocalDate(date);
		return ld.plusDays(days).toDate();
	}

	public static DateTime getDateTimeFromString(String date) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern(SHORT_DATE_FORMAT);
		return dtf.parseDateTime(date);

	}
}
