package parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.parser.nbp.currency.CurrencySymbols;

public class CheckSymbols {

	@Test
	public void checkSymbols() {
		assertTrue(CurrencySymbols.contains("USD"));
		assertTrue(CurrencySymbols.contains("EUR"));
		assertTrue(CurrencySymbols.contains("CHF"));
		assertTrue(CurrencySymbols.contains("GBP"));

		assertFalse(CurrencySymbols.contains(""));
		assertFalse(CurrencySymbols.contains("EURO"));
		assertFalse(CurrencySymbols.contains(null));
		assertFalse(CurrencySymbols.contains("1"));
	}

}
