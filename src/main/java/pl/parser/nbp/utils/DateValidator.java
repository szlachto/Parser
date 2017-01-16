package pl.parser.nbp.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateValidator {

	private static final Logger LOGGER = Logger.getLogger(DateValidator.class.getName());

	public static boolean validateDates(String start, String stop) {

		final LocalDate INIT_DATE = LocalDate.parse("2002-01-02");
		final LocalDate NOW = LocalDate.now();
		final int MAX_DAY_PERIOD = 93;
		final int MIN_DAY_PERIOD = 1;

		LocalDate startDate, stopDate;

		if ((startDate = parseDate(start)) != null && (stopDate = parseDate(stop)) != null) {

			if (!INIT_DATE.isAfter(startDate) && !stopDate.isAfter(NOW)) {

				long period = ChronoUnit.DAYS.between(startDate, stopDate);

				if (period >= MIN_DAY_PERIOD && period <= MAX_DAY_PERIOD) {

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

			LOGGER.log(Level.SEVERE, "Exception occur", e);

		} catch (NullPointerException e) {

			LOGGER.log(Level.SEVERE, "Exception occur", e);
		}

		return d;

	}

}
