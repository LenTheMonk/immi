package de.jahresprojekt.logic.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TimestampUtils{

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
