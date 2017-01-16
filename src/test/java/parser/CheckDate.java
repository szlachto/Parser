package parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.parser.nbp.utils.DateValidator;

public class CheckDate {

	@Test
	public void datesChecker() {

		assertTrue(DateValidator.validateDates("2016-10-10", "2016-10-10"));
		assertTrue(DateValidator.validateDates("2016-10-10", "2016-10-11"));
		assertTrue(DateValidator.validateDates("2002-01-02", "2002-04-05"));
		assertTrue(DateValidator.validateDates("2017-01-02", "2017-01-15"));

		assertFalse(DateValidator.validateDates("2016-10-11", "2016-10-10"));
		assertFalse(DateValidator.validateDates("2016-10-10", "2016-10-1"));
		assertFalse(DateValidator.validateDates("2002-01-02", "2002-04-06"));
		assertFalse(DateValidator.validateDates("2002-01-01", "2002-04-01"));
		assertFalse(DateValidator.validateDates("2017-01-02", "2017-01-16"));
		assertFalse(DateValidator.validateDates(null, "2016-10-10"));
		assertFalse(DateValidator.validateDates(null, null));
		assertFalse(DateValidator.validateDates("2016-10-10", null));

	}

}
