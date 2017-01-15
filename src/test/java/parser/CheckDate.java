package parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.parser.nbp.DateUtil;

public class CheckDate {

	@Test
	public void DatesChecker() {

		assertTrue(DateUtil.validateDates("2016-10-10", "2016-10-10"));
		assertTrue(DateUtil.validateDates("2016-10-10", "2016-10-11"));
		assertTrue(DateUtil.validateDates("2002-01-02", "2002-04-05"));
		assertTrue(DateUtil.validateDates("2017-01-02", "2017-01-15"));

		assertFalse(DateUtil.validateDates("2016-10-11", "2016-10-10"));
		assertFalse(DateUtil.validateDates("2016-10-10", "2016-10-1"));
		assertFalse(DateUtil.validateDates("2002-01-02", "2002-04-06"));
		assertFalse(DateUtil.validateDates("2002-01-01", "2002-04-01"));
		assertFalse(DateUtil.validateDates("2017-01-02", "2017-01-16"));
		assertFalse(DateUtil.validateDates(null, "2016-10-10"));
		assertFalse(DateUtil.validateDates(null, null));
		assertFalse(DateUtil.validateDates("2016-10-10", null));

	}

}
