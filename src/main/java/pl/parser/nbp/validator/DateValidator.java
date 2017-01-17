package pl.parser.nbp.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateValidator {

	private static final Logger LOGGER = Logger.getLogger(DateValidator.class.getName());

	public static boolean validateDates(String start, String stop) {

		final LocalDate FIRST_CURRENCY_RATE = LocalDate.parse("2002-01-02");
		final LocalDate NOW = LocalDate.now();
		final int MAX_DAY_PERIOD = 93;

		LocalDate startDate, stopDate;

		if ((startDate = parseDate(start)) == null || (stopDate = parseDate(stop)) == null) {
			return false;
		}

		if (startDate.isAfter(stopDate)) {
			return false;
		}

		if (FIRST_CURRENCY_RATE.isAfter(startDate)) {
			return false;
		}

		if (stopDate.isAfter(NOW)) {
			return false;
		}

		if (ChronoUnit.DAYS.between(startDate, stopDate) > MAX_DAY_PERIOD) {
			return false;
		}

		return true;
	}

	private static LocalDate parseDate(String date) {

		LocalDate d = null;

		try {
			d = LocalDate.parse(date);

		} catch (DateTimeParseException e) {

			LOGGER.log(Level.SEVERE, "Cannot parse date: " + date);

		}

		return d;

	}

}
