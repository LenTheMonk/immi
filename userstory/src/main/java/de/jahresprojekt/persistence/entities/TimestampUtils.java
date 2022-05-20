import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

import com.fasterxml.jackson.databind.util.StdDateFormat;

public class TimestampUtils{

	public static final Timestamp convertStringToTimestamp(String aTimestampString) {
		if (aTimestampString == null || aTimestampString.trim().length() < 1) {
			return null;
		}
		try {
			return Timestamp.from(StdDateFormat.instance.parse(aTimestampString).toInstant());
		} catch (ParseException e) {
			try {
				return Timestamp.from(java.time.Instant.parse(aTimestampString));
			} catch (DateTimeParseException ex) {
				try {
					return new Timestamp(java.sql.Date.valueOf(aTimestampString).getTime());
				} catch (IllegalArgumentException ex2) {
					try {
						return new Timestamp(new SimpleDateFormat(SIMPLE_DATE_FORMAT).parse(aTimestampString).getTime());
					} catch (ParseException ex3) {
						return null;
					}
				}
			}
		}
	}

	public static final String convertTimestampToString(java.sql.Timestamp aTimestamp) {
		if (aTimestamp == null) {
			return null;
		}
		return StdDateFormat.instance.format(aTimestamp);
	}

	public static final String convertDateToString(Date aDate) {
		if (aDate == null) {
			return null;
		}
		return StdDateFormat.instance.format(aDate);
	}


	public static final boolean isTimestampFromCurrentDay(Timestamp aTimestamp) {
		LocalDateTime currentDayMidnight = LocalDateTime.now().with(LocalTime.MIDNIGHT);
		return (aTimestamp != null && currentDayMidnight.isBefore(aTimestamp.toLocalDateTime()));
	}

	public static Timestamp substractDaysofCurrentTimestamp(Integer days) {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinusGivenDays = currentDate.minusDays(days);
		return Timestamp.valueOf(currentDateMinusGivenDays.atStartOfDay());
	}
	
	public static Timestamp addDaysofCurrentTimestamp(Integer days) {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDatePlusGivenDays = currentDate.plusDays(days);
		return Timestamp.valueOf(currentDatePlusGivenDays.atStartOfDay());
	}

}
