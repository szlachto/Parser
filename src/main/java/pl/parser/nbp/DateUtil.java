package pl.parser.nbp;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateUtil {

	public static boolean validateDates(String start, String stop) {

		final LocalDate INIT_DATE = LocalDate.parse("2002-01-02");
		final LocalDate NOW = LocalDate.now();

		LocalDate startDate, stopDate;

		if ((startDate = parseDate(start)) != null && (stopDate = parseDate(stop)) != null) {

			if (!INIT_DATE.isAfter(startDate) && !stopDate.isAfter(NOW)) {

				long period = checkDaysBetween(startDate, stopDate);

				if (period >= 0 && period <= 93) {

					return true;

				}
			}

		}

		return false;
	}

	private static LocalDate parseDate(String date) {

		LocalDate d = null;

		try {
			d = LocalDate.parse(date);

		} catch (DateTimeParseException e) {

			System.out.println("DataTimeParseException: " + date);

		} catch (NullPointerException e) {

			System.out.println("Missing date input");
		}

		return d;

	}

	private static long checkDaysBetween(LocalDate start, LocalDate stop) {
		return ChronoUnit.DAYS.between(start, stop);
	}

}
