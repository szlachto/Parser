package parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.parser.nbp.SymbolUtil;

public class CheckSymbols {

	@Test
	public void checkSymbols() {
		assertTrue(SymbolUtil.contains("USD"));
		assertTrue(SymbolUtil.contains("EUR"));
		assertTrue(SymbolUtil.contains("CHF"));
		assertTrue(SymbolUtil.contains("GBP"));

		assertFalse(SymbolUtil.contains(""));
		assertFalse(SymbolUtil.contains("EURO"));
		assertFalse(SymbolUtil.contains(null));
		assertFalse(SymbolUtil.contains("1"));
	}

}
